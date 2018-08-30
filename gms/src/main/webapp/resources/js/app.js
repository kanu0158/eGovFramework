"use strict";
/*만약 app이 있다면 있는걸로 대체하고 없으면 새로 만들어라*/
var app = app || {};
var user = user || {};
app = {
		init : x =>{//화면과 기능을 만듬
			console.log('step 1');
			app.session.context(x);
			app.onCreate(x);
			/*let a = x;
			$('#loginBtn').on('click',function(){
				alert('컨텍스트는... :'+a);
			});*/
		},
		onCreate : ()=>{//기능담당
			console.log('step 3');
			app.setContentView();
			//뷰가만들어진 다음에
			/*$('#loginBtn').on('click',()=>{
				console.log('');
			});*/
			$('#loginBtn').click(()=>{
				location.href =app.x()+'/move/auth/member/login';
			});
			
			$('#addBtn').click(()=>{
				location.href =app.x()+'/move/auth/member/add';
			});
			$('#addFormBtn').click(()=>{
				alert('addFormBtn 클릭 : CONTEXT : '+app.x());
				/*var form = document.getElementById('addForm');
				form.action = app.x()+"/member/add";  이렇게하면 action은 어트리뷰트->프로퍼티로 바뀌고 값을 바꿀수있게된다. 
				form.method = "post";
				form.submit();*/
				$('#addForm').attr({
					action:app.x()+"/member/add",
					method:"POST"
				})
				.submit();
				
			});
			$('#loginFormBtn').click(()=>{
				$('#loginForm').attr({
					action:app.x()+"/member/login",
					method:"POST"
				})
				.submit();
			});
			$('#logOutBtn').click(()=>{
				location.href =app.x()+'/member/logout';
			});
			$('#mypageBtn').click(()=>{
				alert('마이페이지 버튼클릭');
				location.href = app.x()+'/member'
			})
			$('#removeBtn').click(()=>{
				location.href =app.x()+'/move/user/member/remove';
			});
			$('#removeFormBtn').click(()=>{
				alert('user아디 : '+app.uI());
				$('#removeForm').append(
					$("<input type='text' value="+sessionStorage.getItem('userId')+" name='userId'>")
				);
				$('#removeForm').attr({
					action:app.x()+"/member/remove",
					method:"POST"
				})
				.submit();
			});
			
			
			$('#modifyBtn').click(()=>{
				alert('modifyBtn 클릭  ');
				location.href =app.x()+'/move/user/member/modify';
			});
			
			$('#modifyFormBtn').click(()=>{
				alert('modifyFormBtn 클릭  ');
				$('#modifyForm').attr({
					action:app.x()+"/member/modify",
					method:"POST"
				})
				.submit();
			});
		},
		setContentView : ()=>{//화면담당
			console.log('step 4 app.session.path(js) :'+app.j());
		}
};
app.session = {
		context : x=>{
			console.log('step 2 x:'+x);
			sessionStorage.setItem('context',x);//내장된 객체와 메소드들
			sessionStorage.setItem('js',x+'/resources/js');
			sessionStorage.setItem('css',x+'/resources/css');
			sessionStorage.setItem('img',x+'/resources/img');
		},
		path : x=>{
			return sessionStorage.getItem(x);
		}
};
app.x = ()=>{
	return app.session.path('context');
};
app.j = ()=>{
	return app.session.path('js');
};
app.c = ()=>{
	return app.session.path('css');
};
app.i = ()=>{
	return app.session.path('img');
};
app.user = {
		init : x=>{
			alert('userId '+x.userId);
			alert('password '+x.password);
			sessionStorage.setItem('userId', x.userId);
			sessionStorage.setItem('password', x.password);
		},
		getUserId : x=>{
			return sessionStorage.getItem(x);
		},
		getPassword : x=>{
			return sessionStorage.getItem(x);
		}
};
app.uI = ()=>{
	return app.user.getUserId('userId');
};
app.ps = ()=>{
	return app.user.getPassword('password');
};

user.session = x=>{
	$.each(x,(k,v)=>{
		alert('key:'+k+', value'+v);
		sessionStorage.setItem(k, v);
	});
	alert(sessionStorage.getItem('userId'));
};



