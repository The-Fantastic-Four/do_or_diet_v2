/*
 * Used to edit and create recipes
 * @author Fannar Þeyr Guðmundsson (fthg2@hi.is)
 * @date September 2017
 */
		var counter = 0;
     	var chcounter = 1;
 		var limit = 40;
     	function addInput(divName){
     		if(counter < limit){
     			var newdiv = document.createElement('div');
     			newHtml = '<div class="field is-grouped">';
     			newHtml += '<div class="control"><input class="input" type="number" step="any" name="quantity" id="quantity' + counter + '" placeholder="Fjöldi"></div>';
     			newHtml += '<div class="control"><input class="input" type="text" name="measurement" id="measurement' + counter + '" placeholder="Mælieining"></div>' ;
     			newHtml += '<div class="control is-expanded"><input class="input" type="text" name="ingredients[name][0]" id="name' + counter + '" placeholder="Hráefni"></div>';
     			newHtml += '</div>';
     			newdiv.innerHTML = newHtml;
     			newdiv.className = 'recipe-ingredient'
     			document.getElementById(divName).appendChild(newdiv);
     			counter++;
     		}else{
     			alert("Þetta er of mikið!");
     		}
     	}
     	
     	function removeInput(divName)
     	{
     		if(counter > 0)
     		{
     			var list = document.getElementById(divName);
     			list.removeChild(list.childNodes[counter]);	
     			counter--;
     		}
     	}
     	
     	function ingredientQuantity(recipeName, ingredientName, measurement, quantity, directions, servings, recipeId)
     	{		
        	this.recipeName = recipeName; 
        	this.ingredientName = ingredientName;
        	this.measurement = measurement;
        	this.quantity = quantity;
        	this.directions = directions;
        	this.servings = servings;
        	this.recipeId = recipeId;
        } 
         	
        function saveChangedRecipe()
        {	
        	chcounter = number instanceof HTMLCollection ? number.length : 1;
        	var arrayNew = [];
     		for	(var i=0; i<chcounter; i++) 
     		{    			
     			var changedIngr = new ingredientQuantity(document.getElementById("recipeName").innerHTML, 
     			document.getElementById('name'+i).innerHTML, 
     			document.getElementById('measurement'+i).innerHTML, 
     			parseFloat(document.getElementById('quantity'+i).innerHTML), 
     			document.getElementById('directions').innerHTML, 
     			parseInt(document.getElementById('servings').innerHTML),
     			parseInt(document.getElementById('recipeId').innerHTML));
     			arrayNew.push(changedIngr);
      		}
      		var xmlhttp = new XMLHttpRequest();       		   	
     	   	xmlhttp.open("POST", "/recipe/changeRecipe/save");
    		xmlhttp.setRequestHeader("Content-Type", "application/json");
    	   	xmlhttp.onload = function()
    	   	{
    	   		if (xmlhttp.status >= 200 && xmlhttp.status < 400) {
    	   			console.log(xmlhttp);  
    	   			window.location.href = "/recipe/";
    	   		} else {
  					alert("Þetta er ekki þín uppskrift, prufaðu að bæta henni í þínar uppskrift");
    	   		}
    	   	};
    		xmlhttp.onerror = function () {
  				alert("Eitthvað slæmt gerðist!!");
			};
			
    	   	xmlhttp.send(JSON.stringify(arrayNew));
    		
         } 	
         	
     	function saveRecipe()
     	{
     		
     		if(document.getElementById('recipeName').value )
     		{

     		}else
     		{
     			alert("Uppskrift verður að heita eitthvað");
     			return;
     		}
     		if(document.getElementById('directions').value)
     		{
     		}else
     		{
     			alert("Vinsamlegast fylltu inn leiðbeiningar");
     			return; 
     		}
			var array = [];

     		for (var i=0;i<counter;i++) 
     		{    			
     			var ingredi = new ingredientQuantity(document.getElementById('recipeName').value, 
     			document.getElementById('name'+i).value, 
     			document.getElementById('measurement'+i).value, 
     			parseFloat(document.getElementById('quantity'+i).value), 
     			document.getElementById('directions').value, 
     			parseInt(document.getElementById('servings').value));
     			array.push(ingredi);
      			
      		}
      		var xmlhttp = new XMLHttpRequest();       		   	
     		   	xmlhttp.open("POST", "/recipe/ingredientQuantity");
    			xmlhttp.setRequestHeader("Content-Type", "application/json");
    		   	xmlhttp.send(JSON.stringify(array));
    			window.location.href = "/recipe";   	
     	}