package com.study.crud.controller;

import com.study.crud.entity.Crud;
import com.study.crud.service.crudService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CrudController {
    @Autowired
    private crudService crudService;

    @GetMapping("/crud")
    public String home(){
        return "home";
    }

    @GetMapping("/crud/create")
    public String create(){

        return "create";
    }

    @PostMapping("/crud/createpro")
    public String createpro(Crud crud, Model model, MultipartFile file)throws Exception{
        crudService.create(crud, file);
        model.addAttribute("message", "글 작성이 완료되었습니다. ");
        model.addAttribute("searchUrl", "/crud/list");
        return "message";
    }

    @GetMapping("/crud/list")
    public String crudList(Model model, @PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable, String searchKeyword){
        Page<Crud> list = null;
        if(searchKeyword == null) {
            list = crudService.crudList(pageable);}
        else{
            list = crudService.crudSearchList(searchKeyword, pageable);
        }
        int nowpage = list.getPageable().getPageNumber()+1;
        int startpage = Math.max(nowpage-4, 1);
        int endpage = Math.min(nowpage+5, list.getTotalPages());
        model.addAttribute("list", list);
        model.addAttribute("nowpage", nowpage);
        model.addAttribute("startpage", startpage);
        model.addAttribute("endpage", endpage);
        return "list";
    }
    @GetMapping("/crud/read")
    public String crudRead(Model model, Integer id){
        model.addAttribute("crud", crudService.read(id));
        return "read";
    }

    @GetMapping("/crud/delete")
    public String crudDelete(Integer id, Model model){
        crudService.delete(id);
        model.addAttribute("message", "글 삭제가 완료되었습니다. ");
        model.addAttribute("searchUrl", "/crud/list");
        return "message";
    }

    @GetMapping("/crud/update/{id}")
    public String crudUpdate(@PathVariable("id") Integer id, Model model){
        model.addAttribute("crud", crudService.read(id));
        return "update";
    }

    @PostMapping("/crud/updatepro/{id}")
    public String crudUpdatePro(@PathVariable("id") Integer id, Crud crud, Model model,
                                MultipartFile file)throws Exception{
        Crud crudTemp=crudService.read(id);
        crudTemp.setTitle(crud.getTitle());
        crudTemp.setContent(crud.getContent());
        crudService.create(crudTemp, file);
        model.addAttribute("message", "글 수정이 완료되었습니다. ");
        model.addAttribute("searchUrl", "/crud/list");
        return "message";
    }
}
