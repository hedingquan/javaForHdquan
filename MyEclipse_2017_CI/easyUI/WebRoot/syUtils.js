var sy=$.extend({},sy);/*定义全局对象*/
sy.serializeObject=
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
