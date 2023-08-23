import { FIND_PRODUCTS_FALIURE, FIND_PRODUCT_BY_ID_FAILURE, FIND_PRODUCT_BY_ID_REQUEST, FIND_PRODUCT_BY_ID_SUCCESS, FIND_PRODUCT_REQUEST, FIND_PRODUCT_SUCCESS } from "./ActionType"

const initalState={
    product:[],
    product:null,
    loading:false,
    error:null
}

  export const customerProductReducer=(state=initalState, action)=>{

    switch(action.type){
        case FIND_PRODUCTS_REQUEST:
            case FIND_PRODUCT_BY_ID_REQUEST:
            return{ ...state,loading:true,error:null}


            case FIND_PRODUCT_SUCCESS:
                return{ ...state,loading:false,error:null,products:action.payload}
                case FIND_PRODUCT_BY_ID_SUCCESS:
                    return{ ...state,loading:false,error:null,products:action.payload}
                    case FIND_PRODUCTS_FALIURE:
                     return{ ...state,loading:false,error:null,products:action.payload}
                     case FIND_PRODUCT_BY_ID_FAILURE:

            default:
                return state;

    }

}