package com.dijiang.staff.test.placeholder;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPlaceholder {
    public static void  main(String [] args){
        String str = null;
        str = String.format("Hi %s: %s. %s","王力宏","刘德华","梁朝伟");
//        System.err.println(str);

//        String sourceSqlStatement = "select  export.id , export.application_id , export.export_status  ,export.file_id  ,  export.completion_time , export.delete_mark , export.file_name , export.csv_header ,record.user_name , record.download_remake , record.download_duration  from tb_export_task export  INNER JOIN tb_file_download_record  record ON export.file_id = record.file_id";
        String sourceSqlStatement = "select  %s, %s , %s  ,%s  ,  %s ,%s , %s , %s ,%s ,%s , %s  from tb_export_task export  INNER JOIN tb_file_download_record  record ON export.file_id = record.file_id";
        String mapping2 = "{" + "\"export.id\":\"导出任务编号\"," +
                "\"export.application_id\":\"系统编号\"," +
                "\"export.export_status\":\"任务导出状态\"," +
                "\"export.file_id\":\"文件id编号\"," +
                "\"export.completion_time\":\"完成导出时间\"," +
                "\"export.delete_mark\":\"任务导出删除标记\"," +
                "\"export.file_name\":\"文件名称\"," +
                "\"export.csv_header\":\".csv文件中/英文列名\"," +
                "\"record.user_name\":\"用户名称\"," +
                "\"record.download_remake\":\"下载备注\"," +
                "\"record.download_duration\":\"下载所耗时常\"" +
                "}";
        String choiceColumns = "export.id,export.application_id,record.download_remake";
        Map<String,String> choiceSqlColumnsAndcsvHeaders =  mappingResolver(mapping2,choiceColumns,sourceSqlStatement);

        String overWrtiteSqlStatement = (String)choiceSqlColumnsAndcsvHeaders.get("overWriteSqlStatement");
        String choiceHeaders =   (String)choiceSqlColumnsAndcsvHeaders.get("choiceHeaders");

        System.err.println("choiceHeaders :"+choiceHeaders);
        System.err.println("overWriteSqlStatement :"+overWrtiteSqlStatement);



//        List<String> choiceSqlColumns = (ArrayList) choiceSqlColumnsAndcsvHeaders.get("choiceSqlColumns");
//
////        List<String> choiceSqlColumns = new ArrayList<>();
//        System.err.println("choiceSqlColumns  :"+ JSON.toJSONString(choiceSqlColumns));
//
//
//
//        //先找出选择的字段 ，减少相应个数的 %s，然后将对应的sqlColumn填进占位符
//        String regx = "%s";
//        Matcher matcher = Pattern.compile(regx).matcher(sourceSqlStatement);
//        int count = 0;
//        while(matcher.find()){
//            count++;
//        }
//        int surplus = (choiceSqlColumns.size()-count);
//        surplus = Math.abs(surplus);
//
//
//        String newSqlStatement = "";
//        newSqlStatement = sourceSqlStatement;
//        for(int i = 0 ; i < surplus; i++ ){
//            newSqlStatement = newSqlStatement.replaceFirst("%s\\s*,","");
//        }
//
//
//        String [] strArray = new String[choiceSqlColumns.size()];
//        choiceSqlColumns.toArray(strArray);
//
//        System.err.println("newSqlStatement ::"+newSqlStatement);
//        String result = String.format(newSqlStatement,strArray);
//        System.err.println("result  ::"+result);




    }

    /* 根据选择的列
     *    重组sqlStatement
     *    重组.csv文件的中/英文列名
     * */
    public static Map<String,String> mappingResolver(String mapping, String choiceColumn,String sourceSqlStatement){

        /* 1.  过滤出选择的sqlColumns .csv文件的中/英文列名*/
        mapping = mapping.replaceAll("\\{","");
        mapping = mapping.replaceAll("\\}","");

        String [] map = mapping.split(",");
        List<String> sourceSqlColumns = new ArrayList<>();
        List<String> sourceHeaders = new ArrayList<>();

        for(int i=0;i<map.length;i++){
            // 数据示例   count[i] 为  "u.name":"姓名"   "u.password":"用户密码" ......
            String [] temp = map[i].split(":");
            sourceSqlColumns.add(temp[0].replace("\"",""));
            sourceHeaders.add(temp[1].replace("\"",""));
        }

        List<String>  choiceSqlColumns = new ArrayList<>();
        StringBuffer choiceHeaders = new StringBuffer();
        String [] choiceColumns = choiceColumn.split(",");
        //  获取数组下标
        List <Integer> indexList = new  ArrayList();
        for(int i=0;i<choiceColumns.length;i++){
            for(int j=0;j<sourceSqlColumns.size();j++){
                if(choiceColumns[i].equals(sourceSqlColumns.get(j))){
                    indexList.add(j);
                }
            }
        }

        for (Integer index:indexList) {
            choiceSqlColumns.add(sourceSqlColumns.get(index));
            choiceHeaders.append(sourceHeaders.get(index)+",");
        }

        choiceHeaders.deleteCharAt(choiceHeaders.length()-1);


        /* 2.  替换占位符 */
        String regx = "%s";
        Matcher matcher = Pattern.compile(regx).matcher(sourceSqlStatement);
        int count = 0;
        while(matcher.find()){
            count++;
        }
        int surplus = (choiceSqlColumns.size()-count);
        surplus = Math.abs(surplus);


        String newSqlStatement = "";
        newSqlStatement = sourceSqlStatement;
        for(int i = 0 ; i < surplus; i++ ){
            newSqlStatement = newSqlStatement.replaceFirst("%s\\s*,","");
        }


        String [] strArray = new String[choiceSqlColumns.size()];
        choiceSqlColumns.toArray(strArray);
        String overWriteSqlStatement = String.format(newSqlStatement,strArray);
        Map<String,String> sqlColumnAndHeader = new HashMap<>();
        sqlColumnAndHeader.put("overWriteSqlStatement",overWriteSqlStatement);
        sqlColumnAndHeader.put("choiceHeaders",new String(choiceHeaders));
        return sqlColumnAndHeader;
    }
}
