function ajaxFunction(){
		var xmlHttp;
		try{
			xmlHttp=new XMLHttpRequest();
		}catch(e)
		{
			try{xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
			catch(e){	
				try{xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					}
				catch(e)
				{}
			}
		}
		return xmlHttp;
	}
window.onload=function()
{

	document.getElementById("ok").onclick=function()
	{
		alert("xxx");
		var xmlReq=ajaxFunction();
		
	}
}