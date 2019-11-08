<!DOCTYPE html>

<html>

<head>
    <meta charset="utf‐8">
    <title>Hello World!</title></head>
<body>
Hello ${name}


<table border="1px solid black" cellpadding="0" cellspacing="0">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>

    <#list stus as stu>
        <tr>
            <td> ${stu_index+1}  </td>
            <td<#if stu.name=='小明'> style="color: red" </#if>> ${stu.name}  </td>
            <td<#if (stu.age>18)> style="color: #ff4238" </#if>> ${stu.age}  </td>
            <td> ${stu.money}  </td>
        </tr>
    </#list>
</table>
输出stu1的学生信息：<br/>
姓名：${stuMap['stu1'].name}<br/>
年龄：${stuMap['stu1'].age}<br/>
输出stu1的学生信息：<br/>
姓名：${stu1.name}<br/>
年龄：${stu1.age}<br/>
遍历输出两个学生信息：<br/>
<hr>
<hr>
<hr>
<table border="1px solid black" cellpadding="0" cellspacing="0">

    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>

    <tr>
        <td>${stu1.name}</td>
        <td>${stu1.age}</td>
        <td>${stu1.money}</td>
    </tr>
</table>
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>出生日期</td>
        <td>钱包</td>
        <td>最好的朋友</td>
        <td>朋友个数</td>
        <td>朋友列表</td>
    </tr>
    <#if stus??>
        <#list stus as stu>

            <td>${stu.name!''}</td>
            <td>${stu.age}</td>
            <td>${(stu.birthday?date)!''}</td>
            <td>${stu.money}</td>
            <td>${(stu.bestFriend.name)!''}</td>
            <td>${(stu.friends?size)!0}</td>
            <td><#if stu.friends??>
                    <#list stu.friends as firend> ${firend.name!''}<br/>
                    </#list>
                </#if>
            </td>
        </#list>
    </#if>

</table>
<hr>
<hr>
<hr>
姓名 : ${stuMap['stu1'].name }
年龄 : ${stuMap['stu1'].age }
<hr>
<hr>
<hr>
姓名 : ${stuMap.stu2.name }
年龄 : ${stuMap.stu2.age }
<hr>
<hr>
<hr>
<table border="1px solid black" cellpadding="0" cellspacing="0">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
    </tr>
    <#list stuMap?keys as  key>
    <tr>
        <td> ${stuMap[key].name}  </td>
        <td> ${stuMap[key].age}  </td>
        <td> ${stuMap[key].money} </td>
    </tr>
    </#list>  

</table>
<br>
<#assign text="{'bank':'工商银行','account':'10101920201920212'}" />
<#assign data=text?eval />
开户行：${data.bank} 账号：${data.account}

</body>

</html>