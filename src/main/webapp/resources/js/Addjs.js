     	var counter = 0;
 		var limit = 40;
     	function addInput(divName){
     		if(counter < limit){
     			var newdiv = document.createElement('div');
     			/*newdiv.innerHTML = '<div class="field"><label class="label">Fjöldi</label>';
     			newdiv.innerHTML += '<div class="control"><input class="input" type="int" name="quantity" id="quantity' + counter + '"></div></div>';
     			newdiv.innerHTML += '<div class="field"><label class="label">Hráefni ' +  (counter + 1) + '</label>';
     			newdiv.innerHTML += '<div class="control"><input class="input" type="text" name="ingredients[name][0]" id="name' + counter + '" placeholder="Text input"></div></div>';
     			newdiv.innerHTML += '<div class="field"><label class="label">Mælieining</label>';
     			newdiv.innerHTML += '<div class="control"><input class="input" type="text" name="measurement" id="measurement' + counter + '"></div></div>' ;*/
     			newHtml = '<div class="field is-grouped">';
     			newHtml += '<div class="control"><input class="input" type="int" name="quantity" id="quantity' + counter + '" placeholder="Fjöldi"></div>';
     			newHtml += '<div class="control is-expanded"><input class="input" type="text" name="ingredients[name][0]" id="name' + counter + '" placeholder="Hráefni"></div>';
     			newHtml += '<div class="control"><input class="input" type="text" name="measurement" id="measurement' + counter + '" placeholder="Mælieining"></div></div>' ;
     			newdiv.innerHTML = newHtml;
     			newdiv.className = 'recipe-ingredient'
     			document.getElementById(divName).appendChild(newdiv);
     			counter++;
     		}else{
     			alert("Þetta er of mikið!");
     		}
     	}
     	
     	function saveRecipe(){
     		function ingredientQuantity(recipeName, ingredientName, measurement, quantity, directions, servings)
     		{		
         		this.recipeName = recipeName; 
         		this.ingredientName = ingredientName;
         		this.measurement = measurement;
         		this.quantity = quantity;
         		this.directions = directions;
         		this.servings = servings;
         	} 
			var array = [];

     		for (var i=0;i<counter;i++) 
     		{    			
     			var ingredi = new ingredientQuantity(document.getElementById('recipeName').value, 
     			document.getElementById('name'+i).value, 
     			document.getElementById('measurement'+i).value, 
     			document.getElementById('quantity'+i).value, 
     			document.getElementById('directions').value, 
     			parseInt(document.getElementById('servings').value));
     			array.push(ingredi);
      			
      		}
      		var xmlhttp = new XMLHttpRequest();       		   	
     		   	xmlhttp.open("POST", "/recipe/ingredientQuantity");
    			xmlhttp.setRequestHeader("Content-Type", "application/json");
    		   	xmlhttp.send(JSON.stringify(array));
     	}
     	