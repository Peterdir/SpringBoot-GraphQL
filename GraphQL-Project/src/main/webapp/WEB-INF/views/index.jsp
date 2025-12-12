<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý sản phẩm - GraphQL Demo</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>Danh sách Product (sắp xếp theo giá tăng dần)</h1>
<button id="btnLoad">Tải dữ liệu</button>
<ul id="productList"></ul>

<h2>Danh sách Product theo Category ID = 1</h2>
<button id="btnCategory">Xem theo Category</button>
<ul id="categoryList"></ul>

<script>
    // Hàm gọi GraphQL endpoint
    function callGraphQL(query, variables = {}) {
        return $.ajax({
            url: '/graphql',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ query: query, variables: variables })
        });
    }

    // Hiển thị tất cả product (price tăng dần)
    $("#btnLoad").click(function () {
        const query = `
            query {
                productsByPriceAsc {
                    id
                    title
                    price
                }
            }
        `;
        callGraphQL(query).done(function (res) {
            const list = $("#productList");
            list.empty();
            res.data.productsByPriceAsc.forEach(p => {
                list.append(`<li>${p.id} - ${p.title} - ${p.price}</li>`);
            });
        });
    });

    // Hiển thị product theo category
    $("#btnCategory").click(function () {
        const query = `
            query($cid: ID!) {
                productsByCategory(categoryId: $cid) {
                    id
                    title
                    price
                    category { id name }
                }
            }
        `;
        callGraphQL(query, { cid: 1 }).done(function (res) {
            const list = $("#categoryList");
            list.empty();
            res.data.productsByCategory.forEach(p => {
                list.append(`<li>${p.title} (${p.category.name}) - ${p.price}</li>`);
            });
        });
    });
</script>

</body>
</html>
