# 1. MOOC在线教育网站配置
> 感谢大佬的毕设，原项目地址：https://github.com/yourmaileyes/MOOC

项目演示地址：http://mooc.ccnoobs.top<br>
项目后台演示地址：http://mooc.ccnoobs.top/admin<br>
管理员账户：admin<br>
管理员密码：admin<br>

MoocV1.10为spring boot框架

1. 登录模块
   在进入系统首页后，首先看到的是登录界面，该界面会提供注册用户的功能，在登录界面，输入用户名之后，
   首先要发送ajax请求验证用户名是否存在，第一时间内给用户提示。
2. 客户端模块
   本模块分为密钥管理，角色管理，权限管理，个人信息，课程信息等组成。
3. 后台管理模块
   本模块包括用户管理，作品信息管理等。
   用户管理：提供管理员查询用户，锁定解锁用户，修改用户信息，充值余额。
   课程信息管理：提供管理员增加删除修改功能。
   系统日志查看：查看所有系统的动作信息。
   访问ip管理：提供对访问IP的管理，可以进行拉黑IP等操作。

**后台访问地址：admin**
**测试用户：1823544517**
**测试密码：123654**

**管理员账户：admin**
**管理员密码：admin**

**充值密码以及删除密码为：591284209**



# 2. git操作

1. 开始之前如果没有设置好用户名和邮箱，需要先配置好用户名，邮箱：

   ```
   # 查看自己的信息
   git config -l
   
   # 修改自己的用户名
   git config --global user.name "Your Name"
   git config --global user.email "email@example.com"
   ```

2. 下载项目到本地：

   ```
   git clone https://gitee.com/peachluis/Mooc.git
   ```

3. 切换分支：

   ```
   # 查看本地有的所有分支
   git branch
   
   # 在本地新建一个分支dev，建立其对远程仓库origin（默认是这个名）的dev分支的链接
   git checkout -b dev origin/dev
   
   # 切换分支（这里只是在本地）
   git checkout 分支名
   ```

   > 这里我们当master分支不存在，每人在自己的分支上进行开发，编码完成后跳到第5步，注意，push到dev分支
   >
   > 开发分支：dev
   >
   > 吴：wu
   >
   > 王：wang
   >
   > **下载到本地后第一件事情就是切换到自己的分支，然后再开始编码**

4. 开始编码——完成编码

5. 添加修改后的文件

   ```
   git add .
   ```

   > 如果出现
   >
   > warning: LF will be replaced by CRLF in README.md. The file will have its original line endings in your working directory
   >
   > 则需要再输入上面命令一次

6. 提交修改后的文件（注意，这里是英文引号，这里只提交到本地）

   ```
   git commit -m "第n次提交，提交内容为。。。"
   ```

7. 上传本地指定分支到远程仓库，这里我们就都只推送到dev分支；master分支是最终版本，不要动

   ```
   git push origin [branch]
   # 我们使用如下，推送到dev分支
   git push origin dev
   ```

   如果这一步推送不成功，可能是有别人先你一步提交到dev分支了，所以你需要使用pull将最新的远程仓库分支同步到本地

   ```
   git pull
   ```

   如果这里又报错说

   > ```
   > There is no tracking information for the current branch.
   > ```

   则是没有链接到远程仓库

   ```
   git branch --set-upstream-to=origin/dev dev
   ```

   之后再pull，然后重复5，6步

   其他更多指令，参看：https://gitee.com/all-about-git