
function getSumPaquete() {
	var altura = document.getElementById('altura').value;
	var ancho = document.getElementById('ancho').value;
	var largo = document.getElementById('largo').value;
	var peso = document.getElementById('peso').value;
	var descuento = document.getElementById('descuentoMiembro').value;
	console.log(altura);
	console.log(ancho);
	console.log(largo);
	console.log(peso);
	console.log(descuento);
	
	//Calculo del precio de los paquetes, según politica de la empresa
	var monto = (altura/3 + ancho/3 + largo/3)*(1+peso/10) ;
	var descontado = monto*descuento;
	var neto = monto - monto*descuento;
	
	document.getElementById('monto').innerHTML = monto.toFixed(2);
	document.getElementById('descontado').innerHTML = descontado.toFixed(2);
	document.getElementById('neto').innerHTML = neto.toFixed(2);
}
