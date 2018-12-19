	GET/orders
fetch('/orders').then(response => response.json().then(console.log))
	POST/orders
fetch(
  '/orders', 
  { 
    method: 'POST', 
   
 headers: { 'Content-Type': 'application/json' },
 
body: JSON.stringify({ quantity:25,unitPrice:11.25,status:"CANCELLED" })
  }
).then(result => result.json().then(console.log))
	PUT/orders/{id}
fetch(
  '/orders/1', 
  { 
   
 method: 'PUT', 
    
headers: { 'Content-Type': 'application/json' }, 
    
body: JSON.stringify({ quantity: 10, unitPrice: 10.5 ,status: 'DONE' })
  }
).then(result => result.json().then(console.log));
	DELETE/orders/{id}
fetch('/orders/3', { method: 'DELETE' }).then(result => console.log(result))
