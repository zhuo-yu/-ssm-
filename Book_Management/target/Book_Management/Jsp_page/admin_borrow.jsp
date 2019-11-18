<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Zy.Pojo.Admin" %>
<%@ page import="Zy.Pojo.BookHistory" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="ax-vertical-centered">
<head>
	<meta charset="UTF-8">
	<title>图书馆管理系统</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../static/css/bootstrap.min.css">
	    <link rel="stylesheet" href="../static/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../static/css/bootstrap-admin-theme.css">
        <link rel="stylesheet" href="../static/css/bootstrap-admin-theme.css">
        <script src="../static/js/bootstrap.min.js"></script>
        <script src="../static/jQuery/jquery-3.1.1.min.js"></script>
            <script src="../static/js/bootstrap-dropdown.min.js"></script>
                      
              <script src="../static/ajax-lib/ajaxutils.js"></script>
            <script src="../static/js/adminUpdateInfo.js"></script>
             <script src="../static/js/adminUpdatePwd.js"></script>
       
</head>



<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>


<body class="bootstrap-admin-with-small-navbar">
<%
Admin admin = (Admin) session.getAttribute("Admin");
%>
    <nav class="navbar navbar-inverse navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small" role="navigation">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="collapse navbar-collapse main-navbar-collapse">
                        <a class="navbar-brand" href="#"><strong>欢迎使用图书馆管理系统</strong></a>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-hover="dropdown"> <i class="glyphicon glyphicon-user"></i> 欢迎您， <s:property value="#session.admin.name"/> <i class="caret"></i></a>
                            
                                 <ul class="dropdown-menu">
                                     <li><a href="#updateinfo" data-toggle="modal">个人资料</a></li>
                                      <li role="presentation" class="divider"></li>
                                       <li><a href="#updatepwd" data-toggle="modal">修改密码</a></li>
                                        <li role="presentation" class="divider"></li>
                                    <li><a href="/books/login.jsp">退出</a></li>
                                </ul>
                                
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>

    <div class="container">
        <!-- left, vertical navbar & content -->
        <div class="row">
            <!-- left, vertical navbar -->
            <div class="col-md-2 bootstrap-admin-col-left">
                <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                     <li>
                        <a href="../Book/BookManage"><i class="glyphicon glyphicon-chevron-right"></i> 图书管理</a>
                    </li>
                    <li>
                        <a href="../Admin/SelectAll"><i class="glyphicon glyphicon-chevron-right"></i> 读者管理</a>
                    </li>
                    <li>
                        <a href="../Type/SelectAll"><i class="glyphicon glyphicon-chevron-right"></i> 图书分类管理</a>
                    </li>
                    <li>
                        <a href="../History/SelectBorrow"><i class="glyphicon glyphicon-chevron-right"></i> 图书借阅信息</a>
                    </li>
                    <li>
                        <a href="../History/SelectReturn"><i class="glyphicon glyphicon-chevron-right"></i> 图书归还信息</a>
                    </li>
                  
                </ul>
                
            </div>

            <!-- content -->
            <div class="col-md-10">
                
                
              <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default bootstrap-admin-no-table-panel">
                            <div class="panel-heading">
                                <div class="text-muted bootstrap-admin-box-title">图书借阅信息</div>
                            </div>
                           
                        </div>
                    </div>
                </div>
                
                
                <div class="row">
                    <div class="col-lg-12">
                        <table id="data_list" class="table table-hover table-bordered" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>图书号</th>
                                <th>图书名称</th>
                                <th>读者账号</th>
                                <th>读者名称</th>
                                <th>借阅日期</th>
                                <th>截止还书日期</th>
                                <th>操作</th>
                                
                            </tr>
                            </thead>
                            
                            
                            <!---在此插入信息-->
                             <%
                             ArrayList<BookHistory> bookhistorydata = (ArrayList<BookHistory>) session.getAttribute("bookhistorydata");
                                for (BookHistory bean : bookhistorydata){
                            %>
                            	<tbody>
	                         	   	<td><%= bean.getCard() %></td>
	                         	   	<td><%= bean.getBookname() %></td>
	                                <td><%= bean.getAdminname() %></td>
	                                <td><%= bean.getUsername() %></td>
	                                <td><%= bean.getBegintime() %></td>
	                                <td><%= bean.getEndtime() %></td>  
<td><button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#updateModal" 
id="btn_update" onclick="haibook(<%=bean.getHid()%>)">还书</button>
	</td>                                            
                          	  </tbody>
                       <%} %> 
                        </table>
                    </div>
                </div>
        </div>
    </div>
    <script type="text/javascript">
    function haibook(hid) {
    	con=confirm("是否还书?"); 
    	if(con==true){
    		location.href = "../History/UpdateBorrow?tip=1&hid="+hid;//tip区分管理员与读者身份,1为管理员,0为读者
    	}
    }
    </script>
    
     
                                     <!-- 修改模态框（Modal） -->
                                     <!-------------------------------------------------------------->  
                                
                                        <!-- 修改模态框（Modal） -->
                               <form class="form-horizontal" method="post" action="/books/updateBookServlet">   <!--保证样式水平不混乱-->   
									<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														&times;
													</button>
													<h4 class="modal-title" id="updateModalLabel">
														修改图书分类
													</h4>
												</div>
												<div class="modal-body">
												
										<!---------------------表单-------------------->
										
										 <div class="form-group">
											<label for="firstname" class="col-sm-3 control-label">图书名称</label>
												<div class="col-sm-7">
													<input type="text" class="form-control" id="updateBookName" name="name"  placeholder="请输入图书名称">
												<label class="control-label" for="updateBookName" style="display: none;"></label>
												</div>
										</div>
											
										</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">关闭
													</button>
													<button type="submit" class="btn btn-primary" >
														修改
													</button>
												</div>
											</div><!-- /.modal-content -->
										</div><!-- /.modal -->
									</div>
	
                                 </form>
                                   <!-------------------------------------------------------------->
 
    
    
    
    
    
    
     <!--------------------------------------添加的模糊框------------------------>  
                                 <form class="form-horizontal" method="post" action="/books/AddBookServlet">   <!--保证样式水平不混乱-->   
                                        <!-- 模态框（Modal） -->
									<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														&times;
													</button>
													<h4 class="modal-title" id="myModalLabel">
														添加新图书分类
													</h4>
												</div>
												<div class="modal-body">
												
										<!---------------------表单-------------------->
										
										 <div class="form-group">
											<label for="firstname" class="col-sm-3 control-label">分类名称</label>
												<div class="col-sm-7">
													<input type="text" class="form-control" id="addBookName" required="required" name="name"  placeholder="请输入图书名称">
													<label class="control-label" for="addBookName" style="display: none;"></label>	
												</div>
										</div>
										
										<!---------------------表单-------------------->
									</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">关闭
													</button>
													<button type="submit" class="btn btn-primary" >
														添加
													</button>
												</div>
											</div><!-- /.modal-content -->
										</div><!-- /.modal -->
									</div>

                                 </form>	
 								<!--------------------------------------添加的模糊框------------------------>  
 
 
    
    
    
    
    
  
<!-------------------------------------------------------------->  
                 
                   <form class="form-horizontal" method="post" action="../Admin/UpdatePassword">   <!--保证样式水平不混乱-->
                                     <!-- 模态框（Modal） -->
				<div class="modal fade" id="updatepwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">
									修改密码
								</h4>
							</div>
							<div class="modal-body">
							 
								<!--正文-->
								<input type="hidden" name="tip" value="1">
								<input type="hidden" name="url" value="admin_borrow">
							<div class="form-group">
								<label for="firstname" class="col-sm-3 control-label">原密码</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" name="confirmpassword" id="oldPwd"  placeholder="请输入原密码">
										<label class="control-label" for="oldPwd" style="display: none"></label>				
								</div>
							</div>	
							
							<div class="form-group">
								<label for="firstname" class="col-sm-3 control-label">新密码</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" name="password" id="newPwd"  placeholder="请输入新密码">
										<label class="control-label" for="newPwd" style="display: none"></label>			
								</div>
							</div>	
							
								<!--正文-->
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭
								</button>
								<button type="submit" class="btn btn-primary" >
									修改
								</button>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal -->
				</div>

				</form>	
                                   <!-------------------------------------------------------------->
                                   
                                   <!-------------------------个人资料模糊框------------------------------------->  
                 
                   <form class="form-horizontal" method="post" action="../Admin/UpdateAdmin">   <!--保证样式水平不混乱-->
                                     <!-- 模态框（Modal） -->
				<div class="modal fade" id="updateinfo" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="ModalLabel">
									个人资料
								</h4>
							</div>
							
							<div class="modal-body">
							 
								<!--正文-->
								<input type="hidden" name="tip" value="2">
								<input type="hidden" name="url" value="admin_borrow">
							<div class="form-group">
								<label for="firstname" class="col-sm-3 control-label">真实姓名</label>
								<div class="col-sm-7">
			<input type="text" class="form-control" id="name" name="name" placeholder="请输入您的真实姓名" value='<% out.write(admin.getName());%>'>
										<label class="control-label" for="name" style="display: none"></label>			
								</div>
							</div>	
							
							<div class="form-group">
								<label for="firstname" class="col-sm-3 control-label">手机号</label>
								<div class="col-sm-7">
			<input type="text" class="form-control" id="phone" name="phone" placeholder="请输入您的手机号" value='<% out.write(admin.getPhone());%>'>
											<label class="control-label" for="phone" style="display: none"></label>				
								</div>
							</div>	
							
							
							<div class="form-group">
								<label for="firstname" class="col-sm-3 control-label">邮箱</label>
								<div class="col-sm-7">
			<input type="text" class="form-control" id="email" name="email"  placeholder="请输入您的邮箱" value='<% out.write(admin.getEmail());%>'>
											<label class="control-label" for="email" style="display: none"></label>				
								</div>
							</div>	
							
								<!--正文-->
								
								
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭
								</button>
								<button type="submit" class="btn btn-primary" >
									修改
								</button>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal -->
				</div>

				</form>	
                                   <!-------------------------------------------------------------->
    
    
    
    
    
    <div class="modal fade" id="modal_info" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="infoModalLabel">提示</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12" id="div_info"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btn_info_close" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
    
    
    
    
    
</body>
</html>