package com.korera.main.Service;

import com.korera.main.Entity.Resource;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ResourceService {


    List<Resource> getAllResources();

    void editResourceByRid(int rid,Resource resource);

    Resource getResourceById(int rid);

    Resource addResource(Resource resource);

    void deleteResource(Resource resource);

    void deleteAllResource();
}
