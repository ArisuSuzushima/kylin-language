# KyLin 编程语言Jvm版本
###### 建议在 Linux 平台上使用该款软件，虽然设计考虑Windows，但是并未在Windows平台上做过测试.

###### 当前版本: 4.0 Public
- KyLin 是一款基于Java开发的跨平台高效的编程语言。面相对象和面向过程都是可以的，直译式编程语言，这是由作者在初三时期开发完成的.

- 其特点就是快速高效简单，语法设计降低或者避免```写出像shit一样的代码```，代码就像诗一样优美.

- Kylin编程语言的目标就是吸取各个编程语言的优点，快速高效的实现```自动化计算机操作```，```计算机编程快速教学```. ```计算机编程语言实现教学```.

#### 发行版 https://gitee.com/LinwinSoft/kylin-language/releases (下载务必到这个链接)

#### 软件信息
- 作者: 王相卿
- 开发语言: Java
- 平台: Windows , Linux
- 面相群体：计算机初学者、办公人员、计算机专业学生.
- 设计目标: ```自动化计算机操作```，```计算机编程快速教学```. ```计算机编程语言实现教学```.

#### 语法改进
- 面相对象的语法结构，但是摒弃了传统编程语言中继承的特性，陈年屎山不该困扰程序员.
- 吸收了 python , vb, c , Linux shell的语法
- 与Java紧密结合，背靠Java丰富生态.
- 变量指针简单化、安全化，指针不再是难点，也不再是限制初学者的一道门槛.

#### 文档
- https://gitee.com/LinWin-Cloud/kylin-language/wiki/

#### 安装


Windows版本直接cmd运行源代码目录内: ```.\kylin.bat [要运行的kylin脚本]```
Linux则进行以下操作(进入目录):
```
sudo mkdir /usr/kylin
sudo cp -r ./* /usr/kylin
sudo echo '/usr/kylin/kylin $1 $2' > /bin/kylin
sudo chmod +x /bin/kylin
sudo chmod 777 /usr/kylin/* -R
```
安装成功后运行命令 ```kylin```
```

Kylin Programming Language.
   -version            Show the version information.
   -console            Enter into the kylin console.
kylin [resource file]

```
输入 ```kylin -console``` 进入kylin编程语言控制台
```
ubuntu@ubuntu-linux:~$ kylin -console
Kylin> print("hello world")
hello world
Kylin> 
```


#### 感谢伙伴
1. Zmh-Program
2. 应急食品
3. 萤火科技 、营销云数据
4. baig
5. Program-Jim
6. 网络风暴
7. Fennd
8. 魔都赵子龙