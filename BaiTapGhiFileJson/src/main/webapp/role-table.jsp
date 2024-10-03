<%@ page import="cm.model.Role" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Roles</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Roles</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Role Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<Role> listRole = (List<Role>) request.getAttribute("roles");
            if (listRole != null && !listRole.isEmpty()) {
                for (Role role : listRole) {
            %>
            <tr>
                <td><%= role.getId() %></td>
                <td><%= role.getRolename() %></td>
                <td>
                    <a class="edit" href="#">Edit</a>
                    <a class="delete" href="#" data-id-role="<%= role.getId() %>">Delete</a>
                </td>
            </tr>
            <% 
                }
            } else {
            %>
            <tr>
                <td colspan="3">No roles found</td>
            </tr>
            <% 
            }
            %>
        </tbody>
    </table>
    <form action="http://localhost:8080/cm/api/role/add" method="post">
    	<input name = "rolename" placeholder="Rolename...">
    	<button type="submit">Thêm</button>
    </form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            $(".delete").click(function(event){
                event.preventDefault();

                var id = $(this).data("id-role");
                var confirmation = confirm("Are you sure you want to delete this role?");
                
                if (confirmation) {
                    $.ajax({
                        method: "POST",
                        url: "http://localhost:8080/cm/api/role",
                        data: { id: id },
                        success: function(response) { 
                            alert("Role deleted successfully.");
                            location.reload();
                        },
                        error: function(xhr, status, error) {
                            console.error("Error: " + error);
                            alert("An error occurred while deleting the role.");
                        }
                    });
                }
            });
        });
    </script>
</body>
</html>
