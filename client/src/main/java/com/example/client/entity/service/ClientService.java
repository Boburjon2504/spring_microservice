package com.example.client.entity.service;

import com.example.client.entity.dto.ApiResponse;
import com.example.client.entity.dto.ClientDTO;
import com.example.client.entity.entity.Client;
import com.example.client.entity.entity.Department;
import com.example.client.entity.feign.DepartmentFeign;
import com.example.client.entity.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    final DepartmentFeign departmentFeign;
    final ClientRepository clientRepository;
    final RestTemplate restTemplate;

    //ctrl +alt + l  cleand code
    public ApiResponse add(ClientDTO clientsDTO) {

        Client client = new Client();
        client.setName(clientsDTO.getName());


        Department response = departmentFeign.getOneDepartment(clientsDTO.getDepartmentId());
        System.out.println(response);


        List<Department> all = departmentFeign.getAll();
        System.out.println(all);

        client.setDepartment(response);
        clientRepository.save(client);
        return new ApiResponse("Added", true, client);
    }

    public ApiResponse edit(Integer id, ClientDTO clientsDTO) {

        Optional<Client> byName = Optional.of(clientRepository.findById(id).get());
        if (byName.isEmpty()) return new ApiResponse("Client Not found!", false);

        Client client = byName.get();
        client.setName(clientsDTO.getName());
//        client.setDepartmentId(clientsDTO.getDepartmentId());
        clientRepository.save(client);
        return new ApiResponse("Edited", true, client);
    }


    public ApiResponse getAll() {
        List<Client> clientsList = clientRepository.findAll();
        return new ApiResponse("Here", true, clientsList);
    }

    public ApiResponse getOne(Integer id) {
        Optional<Client> clients = Optional.of(clientRepository.findById(id).get());
        return new ApiResponse("Here", true, clients);
    }


}
