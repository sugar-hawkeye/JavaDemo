package com.wim.test;

import org.junit.Test;

import org.apache.ibatis.io.Resources;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.wim.pojo.ModelType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

public class ModelTypeTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();

        }catch (IOException ignore){
            ignore.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<ModelType> modelTypes = sqlSession.selectList("selectAll");
            print(modelTypes);
        }finally {
            sqlSession.close();
        }
    }

    private void print(List<ModelType> modelTypes){
        for (ModelType modelType : modelTypes){
            System.out.printf("\n",modelType.getId(),modelType.getModelLabel(),modelType.getModel());
        }
    }
}
