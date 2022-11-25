<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="Aplikacja.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="SqlDataSource1" DataTextField="klient" DataValueField="CustomerID" AutoPostBack="True">
</asp:DropDownList>
<asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:AdventureWorksLTConnectionString %>" SelectCommand="SELECT CustomerID, LastName + ' ' + COALESCE (FirstName + ' ' + MiddleName, FirstName) AS klient FROM SalesLT.Customer ORDER BY klient"></asp:SqlDataSource>
<br />
<asp:DetailsView ID="DetailsView1" runat="server" AutoGenerateRows="False" DataKeyNames="CustomerID" DataSourceID="SqlDataSource2" Height="50px" Width="125px">
    <Fields>
        <asp:BoundField DataField="CustomerID" HeaderText="CustomerID" InsertVisible="False" ReadOnly="True" SortExpression="CustomerID" />
        <asp:CheckBoxField DataField="NameStyle" HeaderText="NameStyle" SortExpression="NameStyle" />
        <asp:BoundField DataField="Title" HeaderText="Title" SortExpression="Title" />
        <asp:BoundField DataField="FirstName" HeaderText="FirstName" SortExpression="FirstName" />
        <asp:BoundField DataField="MiddleName" HeaderText="MiddleName" SortExpression="MiddleName" />
        <asp:BoundField DataField="LastName" HeaderText="LastName" SortExpression="LastName" />
        <asp:BoundField DataField="Suffix" HeaderText="Suffix" SortExpression="Suffix" />
        <asp:BoundField DataField="CompanyName" HeaderText="CompanyName" SortExpression="CompanyName" />
        <asp:BoundField DataField="SalesPerson" HeaderText="SalesPerson" SortExpression="SalesPerson" />
        <asp:BoundField DataField="EmailAddress" HeaderText="EmailAddress" SortExpression="EmailAddress" />
        <asp:BoundField DataField="Phone" HeaderText="Phone" SortExpression="Phone" />
    </Fields>
</asp:DetailsView>
<br />
<asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:AdventureWorksLTConnectionString %>" SelectCommand="SELECT CustomerID, NameStyle, Title, FirstName, MiddleName, LastName, Suffix, CompanyName, SalesPerson, EmailAddress, Phone FROM SalesLT.Customer WHERE (CustomerID = @Param1)">
    <SelectParameters>
        <asp:ControlParameter ControlID="DropDownList1" Name="Param1" PropertyName="SelectedValue" />
    </SelectParameters>
</asp:SqlDataSource>
<asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataSourceID="SqlDataSource3">
    <Columns>
        <asp:BoundField DataField="AddressLine1" HeaderText="AddressLine1" SortExpression="AddressLine1" />
        <asp:BoundField DataField="AddressLine2" HeaderText="AddressLine2" SortExpression="AddressLine2" />
        <asp:BoundField DataField="City" HeaderText="City" SortExpression="City" />
        <asp:BoundField DataField="StateProvince" HeaderText="StateProvince" SortExpression="StateProvince" />
        <asp:BoundField DataField="CountryRegion" HeaderText="CountryRegion" SortExpression="CountryRegion" />
        <asp:BoundField DataField="PostalCode" HeaderText="PostalCode" SortExpression="PostalCode" />
        <asp:BoundField DataField="CustomerID" HeaderText="CustomerID" SortExpression="CustomerID" />
    </Columns>
</asp:GridView>
<asp:SqlDataSource ID="SqlDataSource3" runat="server" ConnectionString="<%$ ConnectionStrings:AdventureWorksLTConnectionString %>" SelectCommand="SELECT SalesLT.Address.AddressLine1, SalesLT.Address.AddressLine2, SalesLT.Address.City, SalesLT.Address.StateProvince, SalesLT.Address.CountryRegion, SalesLT.Address.PostalCode, SalesLT.CustomerAddress.CustomerID FROM SalesLT.Address INNER JOIN SalesLT.CustomerAddress ON SalesLT.Address.AddressID = SalesLT.CustomerAddress.AddressID WHERE (SalesLT.CustomerAddress.CustomerID = @Param1)">
    <SelectParameters>
        <asp:ControlParameter ControlID="DropDownList1" Name="Param1" PropertyName="SelectedValue" />
    </SelectParameters>
</asp:SqlDataSource>
<br />
<asp:GridView ID="GridView2" runat="server" AutoGenerateColumns="False" DataSourceID="SqlDataSource4">
    <Columns>
        <asp:BoundField DataField="RevisionNumber" HeaderText="RevisionNumber" SortExpression="RevisionNumber" />
        <asp:BoundField DataField="OrderDate" HeaderText="OrderDate" SortExpression="OrderDate" />
        <asp:BoundField DataField="DueDate" HeaderText="DueDate" SortExpression="DueDate" />
        <asp:BoundField DataField="ShipDate" HeaderText="ShipDate" SortExpression="ShipDate" />
        <asp:BoundField DataField="Status" HeaderText="Status" SortExpression="Status" />
        <asp:BoundField DataField="Expr1" HeaderText="Expr1" SortExpression="Expr1" />
        <asp:CheckBoxField DataField="OnlineOrderFlag" HeaderText="OnlineOrderFlag" SortExpression="OnlineOrderFlag" />
        <asp:BoundField DataField="SalesOrderNumber" HeaderText="SalesOrderNumber" ReadOnly="True" SortExpression="SalesOrderNumber" />
        <asp:BoundField DataField="PurchaseOrderNumber" HeaderText="PurchaseOrderNumber" SortExpression="PurchaseOrderNumber" />
        <asp:BoundField DataField="AccountNumber" HeaderText="AccountNumber" SortExpression="AccountNumber" />
        <asp:BoundField DataField="ProductID" HeaderText="ProductID" SortExpression="ProductID" />
    </Columns>
</asp:GridView>
<asp:SqlDataSource ID="SqlDataSource4" runat="server" ConnectionString="<%$ ConnectionStrings:AdventureWorksLTConnectionString %>" SelectCommand="SELECT SalesLT.SalesOrderHeader.RevisionNumber, SalesLT.SalesOrderHeader.OrderDate, SalesLT.SalesOrderHeader.DueDate, SalesLT.SalesOrderHeader.ShipDate, SalesLT.SalesOrderHeader.Status, SalesLT.SalesOrderHeader.CustomerID AS Expr1, SalesLT.SalesOrderHeader.OnlineOrderFlag, SalesLT.SalesOrderHeader.SalesOrderNumber, SalesLT.SalesOrderHeader.PurchaseOrderNumber, SalesLT.SalesOrderHeader.AccountNumber, SalesLT.SalesOrderDetail.ProductID FROM SalesLT.SalesOrderHeader INNER JOIN SalesLT.SalesOrderDetail ON SalesLT.SalesOrderHeader.SalesOrderID = SalesLT.SalesOrderDetail.SalesOrderID WHERE (SalesLT.SalesOrderHeader.CustomerID = @Param1)">
    <SelectParameters>
        <asp:ControlParameter ControlID="DropDownList1" Name="Param1" PropertyName="SelectedValue" />
    </SelectParameters>
</asp:SqlDataSource>
<asp:SqlDataSource ID="SqlDataSource5" runat="server"></asp:SqlDataSource>
</asp:Content>
