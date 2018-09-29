/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//dismiss alert after 3 sec
$alert = $('.alert');

if ($alert.length){
    setTimeout(function(){
        $alert.fadeOut('slow');
    }, 3000);
}

