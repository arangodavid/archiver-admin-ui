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

    getAppConfiguration: () => {
        return Query('/ui-api/appSettings/getAll', {
            method: 'GET'
        });
    }
}
