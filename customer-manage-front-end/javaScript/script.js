
loadCustomer();

function loadCustomer() {
    fetch('http://localhost:8080/customer/get-all')
        .then(res => res.json())
        .then(data => {
            let innerCode = `<th>ID</th><th>NAME</th><th>ADDRESS</th><th>SALARY</th>`;
            data.forEach(element => {
                innerCode += `
                <tr>
                    <td>${element.id}</td>
                    <td>${element.name}</td>
                    <td>${element.address}</td>
                    <td>${element.salary}</td>
                </tr>
            `;
            });
            document.getElementById('tblCustomer').innerHTML = innerCode;
        })
}


function addCustomer() {
    if (document.getElementById('txtName').value!=""&&document.getElementById('txtAddress').value!=""&&document.getElementById('txtSalary').value!="") {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
    
        const raw = JSON.stringify({
            "name": document.getElementById('txtName').value,
            "address": document.getElementById('txtAddress').value,
            "salary": document.getElementById('txtSalary').value
        });
    
        const requestOptions = {
            method: "POST",
            headers: myHeaders,
            body: raw,
            redirect: "follow"
        };
    
        console.log(raw);
    
        fetch("http://localhost:8080/customer/add", requestOptions)
            .then((response) => response.text())
            .then((result) => console.log(result))
            .catch((error) => console.error(error)); 
    }
}


function viewCustomer() {
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch(`http://localhost:8080/customer/search-by-id/${document.getElementById('txtId').value}`, requestOptions)
        .then((response) => response.json())
        .then((result) => {
            document.getElementById('txtName').value = result.name;
            document.getElementById('txtAddress').value = result.address;
            document.getElementById('txtSalary').value = result.salary;
        })
        .catch((error) => console.error(error));
}


function updateCustomer() {
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "id": document.getElementById('txtId').value,
        "name": document.getElementById('txtName').value,
        "address": document.getElementById('txtAddress').value,
        "salary": document.getElementById('txtSalary').value
    });

    const requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("http://localhost:8080/customer/update", requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));
}


function deleteCustomer() {
    const requestOptions = {
        method: "DELETE",
        redirect: "follow"
      };
      
      fetch(`http://localhost:8080/customer/delete/${document.getElementById('txtId').value}`, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));
}









function createTable(dataArray){
    let table=`<caption class="fw-bold fs-3"></caption><th>ID</th><th>NAME</th><th>ADDRESS</th><th>SALARY</th>`;

    dataArray.forEach(element => {
        table += `
        <tr>
            <td>${element.id}</td>
            <td>${element.name}</td>
            <td>${element.address}</td>
            <td>${element.salary}</td>
        </tr>
    `;
    });
    document.getElementById('tblSearchCustomer').innerHTML = table;
}



function searchName(){
    const requestOptions = {
        method: "GET",
        redirect: "follow"
      };


      
      
      
      fetch(`http://localhost:8080/customer/search-by-name/${document.getElementById('txtSearch').value}`, requestOptions)
        .then((response) => response.json())
        .then((result) => {
            if(result.length==0){
                searchAddress()
            }else{
                createTable(result);
            }
            
            
            
        })
        .catch((error) => console.error(error));

    
}


function searchAddress(){
    const requestOptions = {
        method: "GET",
        redirect: "follow"
      };

      
      
      fetch(`http://localhost:8080/customer/search-by-address/${document.getElementById('txtSearch').value}`, requestOptions)
        .then((response) => response.json())
        .then((result) => {
            if(result.length==0){
                searchSalary()
            }else{
                createTable(result);
            }
            
        })
        .catch((error) => console.error(error));

    
}

function searchSalary(){
    const requestOptions = {
        method: "GET",
        redirect: "follow"
      };

           
      fetch(`http://localhost:8080/customer/search-by-salary/${document.getElementById('txtSearch').value}`, requestOptions)
        .then((response) => response.json())
        .then((result) => {
            if(result.length==0){
                alert("No record found");
            }else{
                createTable(result);
            }
            
        })
        .catch((error) => console.error(error));
}