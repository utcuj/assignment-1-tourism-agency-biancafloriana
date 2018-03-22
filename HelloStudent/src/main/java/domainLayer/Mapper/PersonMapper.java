package domainLayer.Mapper;

import Exception.PersonGatewayException;
import database.PersonGateway;
import domainLayer.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonMapper {
    private PersonGateway personGateway ;

    public PersonMapper() {
        this.personGateway = new PersonGateway();
    }


    public void insert(Person person)
    {
        try{
            personGateway.insert(person.getFirstName(),person.getLastName(),person.getAge(),person.getCnp());
        }catch(PersonGatewayException e){
            e.printStackTrace();
        }
    }

    public void update(Person person)
    {
        try{
            personGateway.update(person.getIdPerson(),person.getFirstName(),person.getLastName(),person.getAge(),person.getCnp());
        }catch(PersonGatewayException e){
            e.printStackTrace();
        }
    }

    public void delete(Person person)
    {
        try{
            personGateway.delete(person.getIdPerson());
        }catch(PersonGatewayException e){
            e.printStackTrace();
        }
    }

    public List<Person> findAll()
    {
        try{
            ResultSet r = personGateway.findAll();
            List<Person> personList = new ArrayList<>();

            while(r.next()){

                personList.add( new Person(r.getInt("idperson"),r.getString("firstName"),r.getString("lastName"),
                        r.getInt("age"),r.getString("cnp")));


            }
            personGateway.closeConnection();
            return personList;
        }catch(PersonGatewayException | SQLException e){
           e.printStackTrace();
        }
        return null;
    }

}
