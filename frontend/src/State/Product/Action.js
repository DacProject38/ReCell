import { FIND_PRODUCTS_FALIURE, FIND_PRODUCT_BY_ID_SUCCESS, FIND_PRODUCT_REQUEST } from "./ActionType";

export const findProducts = (reqData) => async (dispatch) => {
    dispatch({type:FIND_PRODUCT_REQUEST})
    const {
        colors,
        sizes,
        minPrice,
        maxprice,
        minDiscount,
        category,
        stock,
        sort,
        pageNumber,
        pageSize
    } = reqData;



    try {
    const {data}=api.get(`/api/products/color=${colors}&size=${sizes}&minPrice=${minPrice}&
    maxPrice=${maxPrice}&minDiscount=${minDiscount}&category=${category}&stock=${stock}&sort=
    ${sort}&pageNumber=${pageNumber}&pageSize=${pageSize}`)

    dispatch({type:FIND_PRODUCT_SUCCESS,payload:data})

    } catch (error) { 

        dispatch({type:FIND_PRODUCTS_FALIURE,payload:error.message})
    }

};


export const findProductsById = (reqData) => async (dispatch) => {
    dispatch({type:FIND_PRODUCT_BY_ID_REQUEST})
    const {productId} = reqData;



    try {
    const {data}=api.get(`/api/products/id/${productId}`)

    dispatch({type:FIND_PRODUCT_BY_ID_SUCCESS,payload:data})

    } catch (error) { 

        dispatch({type:FIND_PRODUCTS_BY_ID_FALIURE,payload:error.message})
    }

};