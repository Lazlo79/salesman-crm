package br.com.kproj.salesman.delivery.view;

import br.com.kproj.salesman.delivery.application.TaskService;
import br.com.kproj.salesman.delivery.infrastructure.validators.TaskValidator;
import br.com.kproj.salesman.infrastructure.entity.task.Task;
import br.com.kproj.salesman.infrastructure.exceptions.ValidationException;
import br.com.kproj.salesman.infrastructure.helpers.NormalizeEntityRequest;
import br.com.kproj.salesman.infrastructure.repository.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @Autowired
    private TaskValidator validator;

    @Autowired
    private NormalizeEntityRequest normalizeEntityRequest;

    @InitBinder(value = "task")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/task/save", method = RequestMethod.POST)
    public  @ResponseBody String save(@ModelAttribute @Validated Task task,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors());
        }

        normalizeEntityRequest.doNestedReference(task);
        Task taskSaved = service.register(task);

        return "/task/" + taskSaved.getId();
    }

    @RequestMapping(value = "/task/save", method = RequestMethod.PUT)
    public @ResponseBody String update(@ModelAttribute @Validated Task task,
                                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors());
        }

        normalizeEntityRequest.addFieldsToUpdate(task);
        Task taskSaved = service.register(task);

        return "/task/" + taskSaved.getId();
    }


    @RequestMapping(value="/task/list")
    public ModelAndView list(@PageableDefault(page=0, size=150000)Pageable pageable, Model model) {
        Pager pager = Pager.binding(pageable);

        Iterable<Task> result = this.service.findAll(pager);

        model.addAttribute("tasks", result);
        return new ModelAndView("/task/list-items");
    }


    @RequestMapping(value="/task/{taskId}")
    public ModelAndView viewInfo(@RequestParam(defaultValue="edit",required=false, value="template") String templateName,
                                 @PathVariable Long taskId, Model model) {

        Optional<Task> result = this.service.getOne(taskId);

        model.addAttribute(result.isPresent() ? result.get() : null);
        return new ModelAndView("/task/" + templateName);
    }

}