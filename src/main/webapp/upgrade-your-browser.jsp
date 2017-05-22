<!DOCTYPE html>
<%@ page language="java"  contentType="text/html; charset=UTF-8" %>
<html lang="zh-CN">
    <head>
        <meta charset="UTF-8" />
        <title>请升级你的浏览器</title>
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" >
        <meta name="renderer" content="webkit"/>
        <style type="text/css">
            body,h1,h2,h3,h4,h5,h6,hr,p,blockquote,dl,dt,dd,ul,ol,li,pre,form,fieldset,legend,button,input,textarea,th,td{margin:0;padding:0}
            a{text-decoration:none;color:#0072c6;}a:hover{text-decoration:none;color:#004d8c;}
            body{width:960px;margin:0 auto;padding:10px;font-size: 13px;line-height:20px;color:#454545;font-family:'Microsoft YaHei UI','Microsoft YaHei',DengXian,SimSun,'Segoe UI',Tahoma,Helvetica,sans-serif;}
            h1{font-size:40px;line-height:80px;font-weight:200;margin-bottom:10px;}
            h2{font-size:20px;line-height:25px;font-weight:500;margin:10px 0;}
            p{margin-bottom:10px;}
            .line{clear:both;width:100%;height:1px;overflow:hidden;line-height:1px;border-bottom:1px solid #ccc;margin:10px 0 30px;}
            img{width:34px;height:34px;border:0;float:left;margin-right:10px;}
            span{display:block;font-size:12px;line-height:12px;}
            .clean{clear:both;}
            .browser{padding:10px 0;}
            .browser li{width:180px;float:left;list-style:none;}
            .browser .new{background:url(new.png);width:23px;height:9px;display:inline-block;}
        </style>
    </head>
    <body>
        <h1>是时候升级你的浏览器了</h1>
        <p>你正在使用 Internet Explorer 的过期版本（IE6、IE7、IE8 或使用该内核的浏览器）。这意味着在升级浏览器前，你将无法访问此网站。</p>
        <div class="line"></div>
        <h2>请注意：Windows XP 及 IE6、IE7、IE8 的支持已经结束</h2>
        <p>自 2014 年 4 月 8 日起，Microsoft 不再为 Windows XP 和 Internet Explorer 8 及以下版本提供相应支持和更新。如果你继续使用这些，你将可能受到病毒、间谍软件和其他恶意软件的攻击，无法确保个人信息的安全。请参阅 <a href="http://windows.microsoft.com/zh-cn/windows/end-support-help">Microsoft 关于 Windows XP 支持已经结束的说明</a> 。</p>
        <div class="line"></div>
        <h2>更先进的浏览器</h2>
        <p>推荐使用以下浏览器的最新版本。如果你的电脑已有以下浏览器的最新版本则直接使用该浏览器访问<b id="referrer"></b>即可。</p>
        <ul class="browser">
            <li><a href="http://www.google.cn/chrome/browser/index.html?hl=zh-CN&standalone=1"><img src="http://cdn.dmeng.net/images/chrome.jpg" alt="谷歌浏览器" width="34" height="34" /> 谷歌浏览器<span>Google Chrome</span></a></li>
            <li><a href="http://download.firefox.com.cn/releases/stub/official/zh-CN/Firefox-latest.exe"><img src="http://cdn.dmeng.net/images/firefox.jpg" alt="火狐浏览器" width="34" height="34" /> 火狐浏览器<span>Mozilla Firefox</span></a></li>
            <li><a href="http://windows.microsoft.com/zh-cn/internet-explorer/download-ie"><img src="http://cdn.dmeng.net/images/ie.jpg" alt="IE浏览器" width="34" height="34" /> IE浏览器<span>Internet Explorer</span></a></li>
            <li><a href="http://jifendownload.2345.cn/jifen_2345/2345chrome_k2345886.exe" title="可以免费打电话的浏览器"><img src="http://cdn.dmeng.net/images/2345chrome.png" alt="2345加速浏览器" width="34" height="34" /> 加速浏览器 <span class="new"></span><span>2345 chrome</span></a></li>
            <div class="clean"></div>
        </ul>
        <div class="line"></div>
        <h2>为什么会出现这个页面？</h2>
        <p>如果你不知道升级浏览器是什么意思，请请教一些熟练电脑操作的朋友。如果你使用的不是IE6/7/8，而是360浏览器、QQ浏览器、搜狗浏览器等，出现这个页面是因为你使用的不是该浏览器的最新版本，升级至最新即可。</p>
        <div class="line"></div>
        <h2>一起抵制IE6、IE7、IE8</h2>
        <p>为了兼容这个曾经的浏览器霸主，网页设计人员需要做大量的代码工作，而且最终效果也始终不能让人满意。对于普通用户而言，低版本IE更是一个岌岌可危的安全隐患，在Windows历史上几次大的木马病毒事件都是利用IE漏洞进行传播。所以，请和我们一起抵制IE6、IE7、IE8！</p>
        <script type="text/javascript">
            function Request(name) {
                new RegExp("(^|&)" + name + "=([^&]*)").exec(window.location.search.substr(1));
                return RegExp.$2
            }
            var referrer = Request("referrer");
            var url = document.referrer;
            if (!url == "") {
                x = document.getElementById("referrer")
                x.innerHTML = '&nbsp;<a href="' + url + '">' + url + '</a>&nbsp;';
            } else if (!referrer == "") {
                x = document.getElementById("referrer")
                x.innerHTML = '&nbsp;<a href="' + referrer + '">' + referrer + '</a>&nbsp;';
            }
        </script>
    </body>
</html>
