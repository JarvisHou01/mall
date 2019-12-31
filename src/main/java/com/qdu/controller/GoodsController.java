package com.qdu.controller;

import com.qdu.bean.Goods;
import com.qdu.bean.Page;
import com.qdu.bean.Result;
import com.qdu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("to_add")
    public String to_add(){
        return "goods/add";
    }

    @RequestMapping("to_list")
    public String to_list(){
        return "goods/list";
    }

    /**
     * 添加商品
     * @param picture
     * @param goods
     * @return
     */
    @RequestMapping("add")
    public String add(@RequestParam("picture") MultipartFile picture, Goods goods){
        //图片名称
        String originalFilename = picture.getOriginalFilename();
        //图片后缀  .jpg
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filePath = "D://upload//"; // 上传后的路径
        String fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            picture.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        goods.setPic("/pics/"+fileName);
        int res = goodsService.addGoods(goods);
        return "goods/list";
    }

    /**
     * 查询商品
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Page<Goods> showGoods(@RequestParam(required = false,defaultValue = "1") int pageNum,
                            @RequestParam(required = false,defaultValue = "3") int pageSize){
        return goodsService.queryList(pageNum,pageSize);
    }

    /**
     * 更新商品
     * @param picture
     * @param goods
     * @return
     */
    @RequestMapping("update")
    public String update(@RequestParam("picture") MultipartFile picture,Goods goods){
        if (picture.getOriginalFilename()!=null&&!"".equals(picture.getOriginalFilename())){
            String originalFilename = picture.getOriginalFilename();
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filePath = "D://upload//"; // 上传后的路径
            String fileName = UUID.randomUUID() + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                picture.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            goods.setPic("/pics/"+fileName);
        }
        int res = goodsService.updateGoods(goods);
        return "goods/list";
    }

    /**
     * 修改商品状态 //上架下架
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("changeStatus")
    @ResponseBody
    public Result changeStatus(@RequestParam("id") int id,@RequestParam int status){
        int res = goodsService.changeStatus(id,status);
        Result result = new Result();
        result.setMsg("成功");
        result.setCode(200);
        return result;
    }

}
