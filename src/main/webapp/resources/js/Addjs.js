     	var counter = 0;
 		var limit = 40;
     	function addInput(divName){
     		if(counter < limit){
     			var newdiv = document.createElement('div');
     			newdiv.innerHTML = "hráefni " +  (counter + 1) + " <br><input type='text' name='ingredients[name][0]' id='name" + counter + "' > fjoldi <input type='int' name='quantity' id='quantity" + counter + "'> mælieining <input type='string' name='measurement' id='measurement" + counter + "'> " ;
     			document.getElementById(divName).appendChild(newdiv);
     			counter++;
     		}else{
     			alert("Þetta er of mikið!");
     		}
     	}
     	
     	function saveRecipe(){
     		    	
     		var recipe = {name, directions, servings}; 
 			recipe.name = document.getElementById('recipeName').value;
 		    recipe.directions = document.getElementById('directions').value;
 		    recipe.servings = parseInt(document.getElementById('servings').value); 
     		
     		var xmlhttp = new XMLHttpRequest();   
    		xmlhttp.open("POST", "/recipe");
    		xmlhttp.setRequestHeader("Content-Type", "application/json");
    		xmlhttp.send(JSON.stringify(recipe));
     		     		
 
     		for (var i=0;i<counter;i++) {
     			
     			function ingredientQuantity(recipeName, ingredientName, measurement, quantity){		
         			this.recipeName = recipeName; 
         			this.ingredientName = ingredientName;
         			this.measurement = measurement;
         			this.quantity = quantity;
         		} 	
     			var ingredi = new ingredientQuantity(document.getElementById('recipeName').value, document.getElementById('name'+i).value, document.getElementById('measurement'+i).value, document.getElementById('quantity'+i).value);
      			var xmlhttp = new XMLHttpRequest();    
     			     		   	
     		   	xmlhttp.open("POST", "/recipe/ingredientQuantity");
    			xmlhttp.setRequestHeader("Content-Type", "application/json");
    		   	xmlhttp.send(JSON.stringify(ingredi));
      		}
     	}
     	