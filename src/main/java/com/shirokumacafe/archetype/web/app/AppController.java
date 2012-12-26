package com.shirokumacafe.archetype.web.app;

import com.google.common.collect.Maps;
import com.shirokumacafe.archetype.entity.Task;
import com.shirokumacafe.archetype.entity.User;
import com.shirokumacafe.archetype.service.account.ShiroDbRealm;
import com.shirokumacafe.archetype.service.task.TaskService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.Servlets;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * 应用入口的Controller
 * @author lim
 */
@Controller
@RequestMapping(value = "/app")
public class AppController {

    private static final int PAGE_SIZE = 3;

    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("title", "标题");
    }

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "")
    public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                       @RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request) {

        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Long userId = getCurrentUserId();

        Page<Task> tasks = taskService.getUserTask(userId, searchParams, pageNumber, PAGE_SIZE, sortType);
        model.addAttribute("tasks", tasks);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));

        return "app/app";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("action", "create");
        return "task/taskForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid Task newTask, RedirectAttributes redirectAttributes) {
        User user = new User(getCurrentUserId());
        newTask.setUser(user);

        taskService.saveTask(newTask);
        redirectAttributes.addFlashAttribute("message", "创建任务成功");
        return "redirect:/task/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.getTask(id));
        model.addAttribute("action", "update");
        return "task/taskForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("preloadTask") Task task, RedirectAttributes redirectAttributes) {
        taskService.saveTask(task);
        redirectAttributes.addFlashAttribute("message", "更新任务成功");
        return "redirect:/task/";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        taskService.deleteTask(id);
        redirectAttributes.addFlashAttribute("message", "删除任务成功");
        return "redirect:/task/";
    }

    /**
     * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
     * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
     */
    @ModelAttribute("preloadTask")
    public Task getTask(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            return taskService.getTask(id);
        }
        return null;
    }

    /**
     * 取出Shiro中的当前用户Id.
     */
    private Long getCurrentUserId() {
        ShiroDbRealm.ShiroUser user = (ShiroDbRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }
}

