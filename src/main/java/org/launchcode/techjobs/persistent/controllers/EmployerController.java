package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("Employer", employerRepository.findAll());
        //should it be Employer??
        return "employers/index";
    }
    //not sure if it's correct???

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        } else {
            employerRepository.save(newEmployer);
            return "redirect:";
        }
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

//        Optional optEmployer = null;
//        if (optEmployer.isPresent()) {
//            Employer employer = (Employer) optEmployer.get();

            Optional <Employer> result = employerRepository.findById(employerId);

            if(result.isPresent()) {
            Employer employer = result.get();
            model.addAttribute("employer", employer);
            return "employers/view";
            } else {
                model.addAttribute("employer", employerRepository.findAll());
            }
            return "redirect:../";

            //where did employerID come from

    }
}
