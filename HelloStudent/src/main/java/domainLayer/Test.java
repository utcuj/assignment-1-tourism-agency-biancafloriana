package domainLayer;

import domainLayer.Mapper.ClientMapper;

import java.util.List;

public class Test {



    public static void main(String args[]){
        ClientMapper clientMapper = new ClientMapper();
       // clientMapper.insert(new Client("Vasile","Ion",26,"aer 345","12345678912","1734567890123"));
        List clientList = clientMapper.findAll();
        for (Object i : clientList) {
            System.out.println(((Client)i).toString());
        }

    }
}
