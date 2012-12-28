package com.shirokumacafe.archetype.service.task;


import com.google.common.collect.Lists;
import com.shirokumacafe.archetype.entity.Task;
import com.shirokumacafe.archetype.repository.jpa.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class TaskService {

	private TaskDao taskDao;

	public Task getTask(Long id) {
		return taskDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void saveTask(Task entity) {
		taskDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteTask(Long id) {
		taskDao.delete(id);
	}

	public List<Task> getAllTask() {
		return (List<Task>) taskDao.findAll();
	}

	public Page<Task> getUserTask(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Task> spec = buildSpecification(userId, searchParams);

		return taskDao.findAll(spec, pageRequest);
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Task> buildSpecification(final Long userId, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//        Specification<Task> spec = new Specification<Task>() {
//            @Override
//            public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                List<Predicate> predicates = Lists.newArrayList();
//
//                predicates.add(cb.equal(root.get("id"),userId));
//                Path exp = root.get("title");
//                predicates.add(cb.like(exp, "%"+"abc"+"%"));
//                return cb.and(predicates.toArray(new Predicate[predicates.size()]));  //To change body of implemented methods use File | Settings | File Templates.
//            }
//        };
		Specification<Task> spec = DynamicSpecifications.bySearchFilter(filters.values(), Task.class);
		return spec;
	}

	@Autowired
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
}
