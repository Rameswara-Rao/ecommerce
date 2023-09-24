package dev.ram.prosuctServicettseveninga.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImp implements CategoryService{
    @Override
    public String getAllCategory() {
        return null;
    }

    @Override
    public String getProductInCategory(Long categoryId) {
        return null;
    }
}
