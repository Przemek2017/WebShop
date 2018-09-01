/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){
   switch(menu){
       case 'Products':
           $('#products').addClass('active');
           break;
       case 'About us':
           $('#about').addClass('active');
           break;
       case 'Contact us':
           $('#contact').addClass('active');
           break;
       default:
           $('#home').addClass('active');
           break;
     
   } 
});

