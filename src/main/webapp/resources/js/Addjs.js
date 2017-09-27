     	var counter = 0;
 		var limit = 40;
     	function addInput(divName){
     		if(counter < limit){
     			var newdiv = document.createElement('div');
     			newdiv.innerHTML = "hráefni " +  (counter + 1) + " <br><input type='text' name='ingredients[name][0]' id='Ingredient" + counter + "' > fjoldi <input type='int' name='quantity' id='quantity" + counter + "'> mælieining <input type='string' name='measurement' id='measurement" + counter + "'> " ;
     			document.getElementById(divName).appendChild(newdiv);
     			counter++;
     		}else{
     			alert("Þetta er of mikið!");
     		}
     	}
     	
     	function saveRecipe(){
     		var ingredientsList = new Array();
     		     		
     		function ingredient(i){
     			this.name =  document.getElementById('Ingredient'+i).value; 
     			this.quantity = document.getElementById('quantity'+i).value;
     			this.measurement = document.getElementById('measurement'+i).value;
     		}
     		for (var i=0;i<counter;i++) {
     			ingredientsList[i] = new ingredient(i);
       			console.log(document.getElementById('Ingredient'+i).value);
      		}
     		
     		var recipe = {name, directions, ingredient}; 
 			recipe.name = document.getElementById('recipeName').value;
 		    recipe.directions = document.getElementById('directions').value;
 		    recipe.ingredient = ingredientsList ;
 		    
 		    for(var t=0; t < counter; t++){ 	
 		    	console.log(ingredientsList[t]);
 		    }
 		    
 		   var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
 		   xmlhttp.open("POST", "/recipe");
 		   xmlhttp.setRequestHeader("Content-Type", "application/json");
 		   xmlhttp.send(JSON.stringify(recipe));
     	}
     	