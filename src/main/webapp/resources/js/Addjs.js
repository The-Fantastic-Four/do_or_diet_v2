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
     			
     			function ingredientQuantity(name,quantity, measurement){		
         			this.name =  document.getElementById('name'+i).value; 
         			this.quantity = document.getElementById('quantity'+i).value;
         			this.measurement = document.getElementById('measurement'+i).value;
         		}	
     			var ingredi = new ingredientQuantity(document.getElementById('name'+i).value,document.getElementById('quantity'+i).value, document.getElementById('measurement'+i).value);
      			var xmlhttp = new XMLHttpRequest();    
     			var ingredientType = {name : "th"};
     			ingredientType.name = document.getElementById('name'+i).value;
     			xmlhttp.open("POST", "/recipe/ingredientType");
     			xmlhttp.setRequestHeader("Content-Type", "application/json");
     		   	xmlhttp.send(JSON.stringify(ingredientType));
     		   	
     		   	xmlhttp.open("POST", "/recipe/ingredientQuantity");
    			xmlhttp.setRequestHeader("Content-Type", "application/json");
    		   	xmlhttp.send(JSON.stringify(ingredi));
     		   	
     		   	
      		}
     	}
     	