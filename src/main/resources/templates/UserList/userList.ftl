<#import "../parts/common.ftl" as c>
<#import "../parts/backmain.ftl" as b>

<@c.page>
    <@b.back>
    </@b.back>
List of users
    ${message?ifExists}
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/user/${user.id?ifExists}">edit</a></td>
    </tr>
    <#else>
    No Users
    </#list>
    </tbody>
</table>

</@c.page>