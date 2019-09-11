package com.bob.equrent.dao;

import com.bob.equrent.entity.Equ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EquDaoTest {

    @Autowired
    private EquDao dao;

    @Test
    public void testAdd(){
        Equ equ = new Equ();

        equ.setName("手机");
        equ.setDetailHtml("\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"description\" content=\"这是一个 index 页面\">\n" +
                "    <meta name=\"keywords\" content=\"index\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <meta name=\"renderer\" content=\"webkit\">\n" +
                "    <meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n" +
                "    <link rel=\"icon\" type=\"image/png\" href=\"assets/i/favicon.png\">\n" +
                "    <link rel=\"apple-touch-icon-precomposed\" href=\"assets/i/app-icon72x72@2x.png\">\n" +
                "    <link rel=\"stylesheet\" href=\"assets/css/amazeui.min.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"assets/css/admin.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"assets/css/app.css\">\n" +
                "    <script src=\"assets/js/echarts.min.js\"></script>\n" +
                "    <style>\n" +
                "        .tpl-portlet-components .portlet-title .caption{\n" +
                "            float: inherit;\n" +
                "        }\n" +
                "        .tpl-portlet-components .portlet-title{\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body data-type=\"index\">\n" +
                "<body>\n" +
                "<div class=\"tpl-portlet-components\">\n" +
                "                <div class=\"portlet-title\">\n" +
                "                    <div class=\"caption font-green bold\">\n" +
                "                         添加公司\n" +
                "                    </div>\n" +
                "                    <div class=\"tpl-portlet-input tpl-fz-ml\">\n" +
                "                        <span id=\"warning\" style=\"color: red\"> </span>\n" +
                "                    </div>\n" +
                " \n" +
                " \n" +
                "                </div>\n" +
                "                <div class=\"tpl-block \" style=\"margin-left:18%;\">\n" +
                " \n" +
                "                    <div class=\"am-g tpl-amazeui-form\">\n" +
                " \n" +
                " \n" +
                "                        <div class=\"am-u-sm-12 am-u-md-9\"style=\"text-align:center;\">\n" +
                "                            <form class=\"am-form am-form-horizontal\" id=\"addcompanyinfo\"  enctype=\"multipart/form-data\" >\n" +
                "                                <div class=\"am-form-group\">\n" +
                "                                    <label for=\"username\" class=\"am-u-sm-2 am-form-label\">公司名称 </label>\n" +
                "                                    <div class=\"am-u-sm-4\">\n" +
                "                                        <input type=\"text\" id=\"CompanyName\" name=\"CompanyName\" placeholder=\"公司名称\">\n" +
                "                                    </div>\n" +
                "                                    <label for=\"realname\" class=\"am-u-sm-2 am-form-label\">公司经理</label>\n" +
                "                                    <div class=\"am-u-sm-4\">\n" +
                "                                        <input type=\"text\" name=\"CompanyManager\" placeholder=\"公司经理\">\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                " \n" +
                "                                <div class=\"am-form-group\">\n" +
                "                                \n" +
                "                                     <label for=\"password\" class=\"am-u-sm-2 am-form-label\">固定电话</label>\n" +
                "                                    <div class=\"am-u-sm-4\">\n" +
                "                                        <input type=\"number\"  pattern=\"[0-9]*\" name=\"set1\" placeholder=\"固定电话\">\n" +
                "                                    </div>\n" +
                "                                    <label for=\"email\" class=\"am-u-sm-2 am-form-label\">经理电话</label>\n" +
                "                                    <div class=\"am-u-sm-4\">\n" +
                "                                        <input type=\"number\" pattern=\"[0-9]*\" name=\"CompanyPhone\" placeholder=\"经理电话\">\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"am-form-group\">\n" +
                "                                    <label for=\"phone\" class=\"am-u-sm-2 am-form-label\">公司地址</label>\n" +
                "                                    <div class=\"am-u-sm-4\" style=\"float:left\" >\n" +
                "                                        <input type=\"text\"name=\"CompanyAddress\" placeholder=\"公司地址 \">\n" +
                "                                    </div>\n" +
                "                                    <label for=\"phone\" class=\"am-u-sm-2 am-form-label\">公司logo</label>\n" +
                "                                   <div class=\"am-u-sm-4\">\n" +
                "                                            <div class=\"am-form-group am-form-file\">\n" +
                "                                                <div class=\"tpl-logo\" >\n" +
                "                                                    <img id=\"logo\" src=\"assets/img/logo1.png\" width=\"100%\" alt=\"\">\n" +
                "                                                </div>\n" +
                "                                                <button type=\"button\" class=\"am-btn am-btn-danger am-btn-sm\">\n" +
                "    \t\t\t\t\t\t\t\t\t\t\t\t<i class=\"am-icon-cloud-upload\"></i> 添加公司logo</button>\n" +
                "                                                <input id=\"photo\" type=\"file\" name=\"fileField\">\n" +
                "                                            </div>\n" +
                " \n" +
                "                                        </div>\n" +
                "                                </div>\n" +
                " \n" +
                "                                <div class=\"am-form-group\">\n" +
                "                                    <label for=\"QQ\" class=\"am-u-sm-2 am-form-label\">QQ</label>\n" +
                "                                    <div class=\"am-u-sm-4\">\n" +
                "                                        <input type=\"number\" pattern=\"[0-9]*\" name=\"managerQQ\" placeholder=\"输入你的QQ号码\">\n" +
                "                                    </div>\n" +
                "                                    <label for=\"wechatid\" class=\"am-u-sm-2 am-form-label\">微信号</label>\n" +
                "                                    <div class=\"am-u-sm-4\">\n" +
                "                                        <input type=\"text\" name=\"WhchatID\" placeholder=\"输入你微信号\">\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                               \n" +
                "                                <div class=\"am-form-group\">\n" +
                "                                   \n" +
                "                                 <input type=\"button\" class=\"am-btn am-btn-primary\" value=\"提交\" id=\"idsub\"/>\n" +
                "                               \n" +
                "                                </div>\n" +
                "                            </form>\n" +
                "                            \n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                " \n" +
                "            </div>\n" +
                " \n" +
                " \n" +
                "    <script src=\"/assets/js/jquery.min.js\"></script>\n" +
                "    <script src=\"/assets/js/amazeui.min.js\"></script>\n" +
                "     <script src=\"/assets/js/jquery.form.js\"></script>\n" +
                "<script>\n" +
                "\t//添加公司logo图片时，将选择的图片显示到页面中\n" +
                "\t$(document).ready(function () {\n" +
                "\t\t$(\"#photo\").change(function () {\n" +
                "\t\t\tvar fil = this.files;\n" +
                "\t\t\tfor (var i = 0; i < fil.length; i++) {\n" +
                "\t\t\t\tconsole.log(fil[i]);\n" +
                "\t\t\t\tconsole.log('--------------------------');\n" +
                "\t\t\t\treads(fil[i]);\n" +
                "\t\t\t}\n" +
                "\t\t});\n" +
                "\t\t$(\"#idsub\").click(function(){\n" +
                "\t\t\t/*用ajaxSubmit方法提交表单*/ \n" +
                "\t\t\t//ajaxSubmit 提交表单 需要jquery.form.js\n" +
                "\t\t            $(\"#addcompanyinfo\").ajaxSubmit({\n" +
                "\t\t                type : 'post',\n" +
                "\t\t                url : \"/companysave\" , //变量\n" +
                "\t\t                async:true, \n" +
                "\t\t                error : function() {//请求失败处理函数  \n" +
                "\t\t                \talert(\"您添加公司失败\");\n" +
                "\t\t                },\n" +
                "\t\t                success : function(data) { //请求成功后处理函数。\n" +
                "\t\t                \t  alert(\"公司添加成功\");\n" +
                "\t\t                }\n" +
                "\t\t            });\n" +
                "\t\t})\n" +
                "\t});\n" +
                "\t//读取选取的图片\n" +
                "\tfunction reads(fil){\n" +
                "\t\tvar reader = new FileReader();\n" +
                "\t\treader.readAsDataURL(fil);\n" +
                "\t\treader.onload = function(){\n" +
                "\t\t\t// document.getElementById(\"dd\").innerHTML += \"<img src='\"+reader.result+\"'>\";\n" +
                "\t\t\t$(\"#logo\").attr(\"src\",reader.result)\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t</script>\n" +
                "\n" +
                "————————————————\n" +
                "版权声明：本文为CSDN博主「Sunday2017」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\n" +
                "原文链接：https://blog.csdn.net/Sunday2017/article/details/82454148");
        Equ save = dao.save(equ);
        System.out.println(save);
    }
}