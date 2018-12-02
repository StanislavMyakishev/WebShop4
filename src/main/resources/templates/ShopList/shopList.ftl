<#import "../parts/common.ftl" as c>
<#import "../parts/backmain.ftl" as b>

<@c.page>
    <@b.back>
    </@b.back>
List of shops
    ${message?ifExists}
<a href="/shop/edit/">EDIT</a>
<div>
    <form method="post">
        <input type="text" name="shopName" placeholder="Название магазина"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
</div>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list shops as shop>
    <tr>
        <td>${shop.id}</td>
        <td>${shop.shopname}</td>
    </tr>
    <#else>
    No shops
    </#list>
    </tbody>
</table>

</@c.page>