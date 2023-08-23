import { ADD_ITEM_TO_CART_FALIURE, ADD_ITEM_TO_CART_REQUEST, ADD_ITEM_TO_CART_SUCCESS, GET_CART_FAILURE, GET_CART_REQUEST } from "./ActionType"

const initalState={
    cart:null,
    loading:false,
    error:null,
    cartItems:[],
}

const cartReducer=(state=initalState,action)=>{

    switch(action.type){
        case ADD_ITEM_TO_CART_REQUEST:
        return{ ...state,loading:true,error:null};
        case ADD_ITEM_TO_CART_SUCCESS:
            return{
             ...state, cartItems: [...state.cartItems,action.payload.cartItems],
             loading:false,
            };

            case ADD_ITEM_TO_CART_FALIURE:
                return{ ...state,loading:false,error:action.payload};
                case GET_CART_REQUEST:
                    return

    }
}