$(function(){
var $users = $('#users');
var $username = $('#newUsernameInput');
var $password = $('#newPasswordInput');

$.ajax({
    type:'GET',
    url:'http://localhost:8080/api/users',
    success: function(users){

        $.each(users, function(i, user){
            $users.append('<li>Username  ' + user.username + ', password: ' + user.password + '</li>');
        })
    }
});

$('#addUser').on('click', function(){
    var user = {
        username: $username.val(),
        password: $password.val()
    };

    console.log(user);
    $.ajax({
        type:'POST',
        url:'/api/users',
        contentType: "application/json",
        data:JSON.stringify(user),
        success: function(newUser){
            console.log("hewrerer");

                $users.append('<li>Username  ' + newUser.username + ', password: ' + newUser.password + '</li>');

        }
    });


})

});