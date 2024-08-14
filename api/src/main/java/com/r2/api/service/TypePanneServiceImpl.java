package com.r2.api.service;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.TypePanne;
import com.r2.api.repository.TypePanneRepository;
@Service
@AllArgsConstructor
public class TypePanneServiceImpl implements TypePanneService {
    TypePanneRepository typepanneRepository;
    
    @Override
    public TypePanne postTypePanne(TypePanne typepanne) throws Exception {
        try{
            return typepanneRepository.save(typepanne);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } }

    @Override
    public List<TypePanne> getTypePanne() throws Exception {
        return typepanneRepository.findAll();
     }

    @Override
    public TypePanne putTypePanne(Integer id, TypePanne typepanne) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putArticle'");
    }

    @Override
    public String deleteTypePanne(Integer id) throws Exception {
        try{
            typepanneRepository.deleteById(id);
            return "TypePanne supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }}

}
