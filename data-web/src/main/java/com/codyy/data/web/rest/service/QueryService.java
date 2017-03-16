package com.codyy.data.web.rest.service;

import org.saiku.olap.query2.ThinQuery;
import org.saiku.service.olap.ThinQueryService;
import org.saiku.web.rest.objects.resultset.QueryResult;
import org.saiku.web.rest.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.data.web.rest.model.QueryRequestJson;
import com.codyy.data.web.rest.model.QueryResponseJson;

/**
 * 处理查询的service
 * @author  xinsheng.zhao
 *
 */
@Service
public class QueryService {

    @Autowired
    ThinQueryService thinQueryService;
    
     
     public QueryResponseJson executeQuery(QueryRequestJson queryRequestJson){
         ThinQuery thinQuery = converToQueryObject(queryRequestJson);
         
         QueryResult queryResult = RestUtil.convert(thinQueryService.execute(thinQuery));
         
         return parserQueryResult(queryResult);
     }
     
     private ThinQuery converToQueryObject(QueryRequestJson queryRequestJson){
         return null;
    }
     
     private QueryResponseJson parserQueryResult(QueryResult queryResult){
         return null;
     }
}



//private ThinQuery restrictQueryByDate(ThinQuery tq) {  
//    
//    ThinQueryModel queryModel = tq.getQueryModel();  
//    Map<AxisLocation, ThinAxis> axesMap = queryModel.getAxes();  
//      
//    NamedList<ThinHierarchy> namedList = new NamedListImpl<ThinHierarchy>();  
//      
//    ThinAxis filterAxis = axesMap.get(AxisLocation.FILTER);  
//    List<ThinHierarchy> filterHie = filterAxis.getHierarchies();  
//      
//    namedList = this.resetThinHierachy(filterHie);  
//          
//    //将修改后的Row重新set到queryModel  
//    if(namedList.size() > 0) {  
//          
//        ThinAxis newFilterAxis = new ThinAxis(  
//                AxisLocation.FILTER,  
//                namedList,  
//                filterAxis.isNonEmpty(),  
//                filterAxis.getAggregators()  
//                );  
//          
//        axesMap.put(AxisLocation.FILTER,newFilterAxis);  
//    }  
//      
//    //将修改后的Row重新set到queryModel  
//    if(namedList.size() == 0) {  
//          
//        ThinAxis rowAxis = axesMap.get(AxisLocation.ROWS);  
//        List<ThinHierarchy> rowHie = rowAxis.getHierarchies();  
//          
//        namedList = this.resetThinHierachy(rowHie);  
//          
//        if(namedList.size() > 0) {  
//            ThinAxis newRowsAxis = new ThinAxis(  
//                    AxisLocation.ROWS,  
//                    namedList,  
//                    rowAxis.isNonEmpty(),  
//                    rowAxis.getAggregators()  
//                    );  
//              
//            axesMap.put(AxisLocation.ROWS,newRowsAxis);  
//        }     
//    }  
//      
//    //若rows中不包含[日期]维度，则判断culowns中是否包含；  
//    //若columns中包含[日期]维度，且没有限制时间区间，则限制为当天；不包含[日期]维度，则强制添加[日期]维度，并限制时间为当天；  
//    if(namedList.size() == 0) {  
//          
////          namedList.clear();  
//          
//        ThinAxis colAxis = axesMap.get(AxisLocation.COLUMNS);  
//        List<ThinHierarchy> colHie = colAxis.getHierarchies();  
//          
//        namedList = this.resetThinHierachy(colHie);  
//          
//        if(namedList.size() == 0) {  
//              
//            //若list为空，则说明columns中不包含日期维度,将colHie加入list中，并强制添加日期维度  
//            namedList.addAll(colHie);  
//              
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
//            String yesterday = format.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));  
//              
//            String newDateMdx = "[日期].[日期].["+yesterday+"]";  
//              
//            ThinMember thinMember = new ThinMember(yesterday,newDateMdx,yesterday);  
//            ThinHierarchy thinHie = new ThinHierarchy();  
//              
//            thinHie.setName("[日期].[日期]");  
//              
//            List<ThinMember> thinMemberList = new ArrayList<ThinMember>();  
//            thinMemberList.add(thinMember);  
//            ThinSelection selection = new ThinSelection();  
//            selection.setMembers(thinMemberList);  
//            selection.setType(ThinSelection.Type.INCLUSION);  
//            ThinLevel thinLevel = new ThinLevel(yesterday,yesterday,selection,null);  
//    //              thinLevel.setSelection(selection);  
//            Map<String,ThinLevel> mapLevel = new LinkedHashMap<String,ThinLevel>();  
//            mapLevel.put("日期", thinLevel);  
//                  
//            thinHie.setLevels(mapLevel);  
//              
//            namedList.add(thinHie);  
//            ThinAxis newColAxis = new ThinAxis(  
//                    AxisLocation.COLUMNS,  
//                    namedList,  
//                    colAxis.isNonEmpty(),  
//                    colAxis.getAggregators()  
//                    );  
//              
//            axesMap.put(AxisLocation.COLUMNS,newColAxis);  
//        }  
//    }  
//      
//    return tq;  
//  }  
//    
//  private NamedList<ThinHierarchy> resetThinHierachy(List<ThinHierarchy> hieList) {  
//        
//      NamedList<ThinHierarchy> namedList = new NamedListImpl<ThinHierarchy>();  
//      boolean flag = false;  
//        
//      for(ThinHierarchy hie : hieList) {  
//            if(hie.getName().equals("[日期].[日期]")) {  
//                  
//                if(hie.getLevels().get("日期").getSelection() == null) {  
//                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
//                    String yesterday = format.format(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));  
//                      
//                    String newDateMdx = "[日期].[日期].["+yesterday+"]";  
//                      
//                    ThinMember thinMember = new ThinMember(null,newDateMdx,yesterday);  
//                      
//                    List<ThinMember> thinMemberList = new ArrayList<ThinMember>();  
//                    thinMemberList.add(thinMember);  
//                    ThinSelection selection = new ThinSelection();  
//                    selection.setMembers(thinMemberList);  
//                      
//                    hie.getLevels().get("日期").setSelection(selection);  
//                }  
//                  
//                flag = true;  
//            }  
//              
//            namedList.add(hie);  
//        }  
//      if(flag) return namedList;  
//        
//      namedList.clear();  
//      return namedList;  
//  }  