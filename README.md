# -visual-data-management-system
_Python爬取CSgo官网武器数据并储存在MySQL数据库，然后使用spring boot和，Vue做可视化管理系统（包含对武器的真山改插和数据库数据查取后，以图表的形式展现在首页）_


**_权限使用的是shiro,增删改的请求地址分别给与增删改权限，用户表当角色为admin时，请手动赋予他的perm属性 add,update,delete ,(Controller下同一请求地址加上两个条件，默认是AND逻辑,这与我们原本设想的，想让admin可以访问所有的请求地址，并且增删改查各自授予增删改查权限的才能进行增删改查，最初的初衷相反)_**
![image](https://github.com/1491646020/visual-data-management-system/assets/84949295/68c1ec7a-27dc-44b3-a162-d2ff05450bd8)

![image](https://github.com/1491646020/visual-data-management-system/assets/84949295/fd46fd0f-24c2-4cbc-a361-71dc676539d7)

**这样去替代：**

![image](https://github.com/1491646020/visual-data-management-system/assets/84949295/61766af6-53cb-4d02-9ce3-370642027674)
