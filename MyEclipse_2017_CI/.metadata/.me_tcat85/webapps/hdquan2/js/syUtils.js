//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

/*将form表单元素的值序列化成对象*/
	function serializeObject(form){
        var o={};
        $.each(form.serializeArray(),function(index){
            
                  if(o[this['name'] ]){
               
                       o[this['name'] ] = o[this['name'] ] + "," + this['value'];

                   }else{

                      o[this['name'] ]=this['value'];

                   }

            })

          return o;
   }
	
	$.fn.serializeObject = function() {
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name]) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	};
	
	/*获取当前项目的根路径*/
function sy()
{
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	var localhostPaht=curWwwPath.substring(0,pos);
	var projectName=pathName.substring(0, pathName.substr(1).indexOf("/")+1);
	return (localhostPaht+projectName);
};


function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";
 
    var uuid = s.join("");
    return uuid;
}

$.extend($.fn.datagrid.methods, {
	addEditor : function(jq, param) {
	if (param instanceof Array)
	{
		$.each(param, function(index, item) 
				{
		var e = $(jq).datagrid('getColumnOption', item.field);
		e.editor = item.editor;
				});
	} else {
		var e = $(jq).datagrid('getColumnOption', param.field);
		e.editor = param.editor;
			}
},
removeEditor : function(jq, param) {
	if (param instanceof Array) {
	$.each(param, function(index, item) {
		var e = $(jq).datagrid('getColumnOption', item);
		e.editor = {};
		});
	} else {
		var e = $(jq).datagrid('getColumnOption', param);
		e.editor = {};
			}
	}
});
//添加行时,改变editor--部分可编辑，部分不可编辑
EditorAddRow = function()
{
		datagrid.datagrid('addEditor',{//可编辑
 		field:'username',
 		editor:{
 			   type:'validatebox',
 			   options:{required:true}
 		}
 	});
	datagrid.datagrid('removeEditor',['createdatetime','enddatetime']);//不可编辑
};
//编辑行时，改变editor
EditorEditRow = function()
{
	datagrid.datagrid('removeEditor','username');
	datagrid.datagrid('addEditor',[{//可编辑
 		field:'createdatetime',
 		editor:{
 			   type:'datetimebox',
 			   options:{required:true}
 		}
 	},{//可编辑
 		field:'enddatetime',
 		editor:{
 			   type:'datetimebox',
 			   options:{required:true}
 		}
 	}]);
};/*
//时间格式化
Date.prototype.format = function (format) {  
	if(isNaN(this.getMonth()))
		{return '';
		}
	if(!format)
		{
		format = "yyyy-MM-dd hh:mm:ss";
		}
	
var o = {  
 "M+": this.getMonth() + 1,
 "d+": this.getDate(), 
 "h+": this.getHours(),
 "m+": this.getMinutes(),
 "s+": this.getSeconds(),
 "q+": Math.floor((this.getMonth() + 3) / 3),
 "S": this.getMilliseconds()
 }  ;

    if (/(y+)/.test(format))  

        format = format.replace(RegExp.$1, (this.getFullYear() + "")  

            .substr(4 - RegExp.$1.length));  

    for (var k in o)  

        if (new RegExp("(" + k + ")").test(format))  

            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));  

    return format;  

};

function formatDatebox(value) {  

    if (value == null || value == '') {  

        return '';  

    }  

    var dt;  

    if (value instanceof Date) {  

        dt = value;  

    } else {  

        dt = new Date(value);  

    }  

    return dt.format("yyyy-MM-dd"); //扩展的Date的format方法(上述插件实现)  

}
  */
/**
 * 更换主题 
 */
changeTheme = function(type){
	var $easyuiTheme = $('#easyuiTheme');
	var url = $easyuiTheme.attr('href');
	console.info(url);
	var href = url.substring(0, url.indexOf('easyui'))+ 'easyui/' + type + '/easyui.css';
	console.info(href);
	$easyuiTheme.attr('href',href);
	
	/* 如果使用了iframe  则要添加下面这段代码、否则的话iframe中的内容不会出现样式的改变
	var $iframe = $('iframe');
	if($ifram.length > 0){
		for ( var i = 0; i < $iframe.length; i++) {
			var ifr = $iframe[i];
			$(ifr).contents.find('#easyuiTheme').attr('href', href);
			
		}
	}
	*/
	$.cookie('easyuiThemeName', type, {
		expires : 7
	});
};

$.extend($.fn.datagrid.defaults.editors,{
	multiplecombobox: {
        init: function(container, options){
            var combo = $('<input type="text">').appendTo(container);
            options.multiple = true;
            combo.combobox(options || {});
            return combo;
        },
        destroy: function(target){
            $(target).combobox('destroy');
        },
        getValue: function(target){
            var opts = $(target).combobox('options');
            if (opts.multiple){
                return $(target).combobox('getValues').join(opts.separator);
            } else {
                return $(target).combobox('getValue');
            }
        },
        setValue: function(target, value){
            var opts = $(target).combobox('options');
            if (opts.multiple){
                if (value == ''){
                    $(target).combobox('clear');
                } else {
                    $(target).combobox('setValues', value.split(opts.separator));//第二个参数只能是传的是id
                }
            } else {
                $(target).combobox('setValue', value);
            }
        },
        resize: function(target, width){
            $(target).combobox('resize', width)
        }
    }
});
