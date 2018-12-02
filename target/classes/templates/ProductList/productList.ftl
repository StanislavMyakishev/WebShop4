<#import "../parts/common.ftl" as c>
<#import "../parts/backmain.ftl" as b>

<@c.page>
    <@b.back>
    </@b.back>
List of products
<a href="/product/edit/">EDIT</a>
    ${message?ifExists}
<div>
    <form method="post">
        <input type="text" name="productName" placeholder="Название товара"/>
        <input type="number" step="0.01" name="productCost" placeholder="Цена товара"/>
        <input type="number" name="productAmount" placeholder="Колличество"/>
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
        <th>Cost</th>
        <th>Amount</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
    <tr>
        <td>${product.productid}</td>
        <td>${product.productname}</td>
        <td>${product.productcost}</td>
        <td>${product.productamount}</td>
    </tr>
    <#else>
    No products
    </#list>
    </tbody>
</table>
</@c.page>