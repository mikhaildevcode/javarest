const baseUrl = '/api/employees';

function createEmployee() {
    fetch(baseUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            name: document.getElementById('create-name').value,
            department: document.getElementById('create-dept').value,
            email: document.getElementById('create-email').value
        })
    })
    .then(r => r.json())
    .then(() => getAllEmployees());
}

function getAllEmployees() {
    fetch(baseUrl)
        .then(r => r.json())
        .then(data => {
            const table = document.getElementById('all-table');
            table.innerHTML = '<tr><th>ID</th><th>Name</th><th>Department</th><th>Email</th></tr>' +
                data.map(e => `<tr><td>${e.id}</td><td>${e.name}</td><td>${e.department}</td><td>${e.email}</td></tr>`).join('');
        });
};
// window.onload = getAllEmployees;
window.addEventListener('load', getAllEmployees);

function getEmployee() {
    const id = document.getElementById('get-id').value;
    fetch(`${baseUrl}/${id}`)
        .then(r => {
            if (!r.ok) throw new Error('Not found');
            return r.json();
        })
        .then(emp => {
            document.getElementById('get-result').textContent = JSON.stringify(emp, null, 2);
        })
        .catch(() => {
            document.getElementById('get-result').textContent = 'Employee not found';
        });
}

function updateEmployee() {
    const id = document.getElementById('update-id').value;
    fetch(`${baseUrl}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            name: document.getElementById('update-name').value,
            department: document.getElementById('update-dept').value,
            email: document.getElementById('update-email').value
        })
    })
    .then(() => getAllEmployees());
}

function deleteEmployee() {
    const id = document.getElementById('delete-id').value;
    fetch(`${baseUrl}/${id}`, { method: 'DELETE' })
        .then(() => getAllEmployees());
}