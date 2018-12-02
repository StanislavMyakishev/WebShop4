<#import "../parts/common.ftl" as c>
<#import "../parts/backmain.ftl" as b>

<@c.page>
    <@b.back>
    </@b.back>
List of products
    ${message?ifExists}
<div>
    <form method="post">
        <input type="text" name="productname" placeholder="Название товара"/>
        <input type="number" step="0.01" name="productcost" placeholder="Цена товара"/>
        <input type="number" name="productamount" placeholder="Колличество"/>
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
        <td><a href="/product/edit/${product.productid?ifExists}">edit</a></td>
    </tr>
    <#else>
    No products
    </#list>
    </tbody>
</table>
</@c.page>