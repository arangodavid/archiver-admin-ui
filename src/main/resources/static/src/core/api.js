import Query from './query.js';

export default {
    getBulkJobList: () => {
        return Query('/ui-api/bulkJobConfig/getAll', {
            method: 'GET'
        });
    },
    saveBulkJob: (data) => {
        return Query('/ui-api/bulkJobConfig/save', {
            method: 'POST',
            body: data
        });
    },
    deleteBulkJob: (data) => {
        return Query('/ui-api/bulkJobConfig/delete', {
            method: 'POST',
            body: data
        });
    },


    getJobLogList: () => {
        return Query('/ui-api/jobLog/getAll', {
            method: 'GET'
        });
    },


    checkCondition: (data) => {
        return Query('/ui-api/sqlUtils/checkCondition', {
            method: 'POST',
            body: data
        });
    },

    //app-configuration
    getAppConfiguration: () => {
        return Query('/ui-api/appSettings/getAll', {
            method: 'GET'
        });
    },

    saveSfUserCredentials: (data) => {
        return Query('/ui-api/appSettings/saveSfUserCredentials', {
            method: 'POST',
            body: data
        });
    },

    saveBaseUrl: (data) => {
        return Query('/ui-api/appSettings/saveList', {
            method: 'POST',
            body: data
        });
    },

    //object-configuration
    getSoapObj: () => {
        return Query('/ui-api/soapObject/getAll', { //Endpoint to be updated
            method: 'GET'
        });
    },

    saveSoapObj: (data) => {
        return Query('/ui-api/soapObject/save', { //Endpoint to be updated
            method: 'POST',
            body: data
        });
    },

    deleteSoapObj: (data) => {
        return Query('/ui-api/soapObject/delete', { //Endpoint to be updated
            method: 'POST',
            body: data
        });
    }
}
