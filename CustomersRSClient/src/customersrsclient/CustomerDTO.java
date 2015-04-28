
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customersrsclient;

public class CustomerDTO {

    public Integer id;
    public String name;
    public String email;
    public int age;

    @Override
    public String toString() {
        return "CustomerDTO{" + "id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + '}';
    }

    public CustomerDTO() {
    }

}
