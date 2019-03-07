import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);



let routes = [];

// Home
import Home from '../pages/home/';
routes.push({
    path: '/',
    name: 'home',
    component: Home
});

// Login
import Login from '../pages/login/';
routes.push({
    path: '/login',
    name: 'login',
    component: Login
});

// Bulk Jobs
import BulkJobs from '../pages/bulk-jobs/';
routes.push({
    path: '/bulk-jobs',
    name: 'bulkJobs',
    component: BulkJobs
});

// Relationship Manager
import RelationshipManager from '../pages/relationship-manager/';
routes.push({
    path: '/relationship-manager',
    name: 'relationshipManager',
    component: RelationshipManager
});

// Job Logs
import JobLogs from '../pages/job-logs/';
routes.push({
    path: '/job-logs',
    name: 'jobLogs',
    component: JobLogs
});

// App Configuraion
import AppConfiguraion from '../pages/app-configuration/';
routes.push({
    path: '/app-configuraion',
    name: 'appConfiguraion',
    component: AppConfiguraion
});

// 404
import NotFound from '../pages/404/';
routes.push({
    path: '/404',
    name: '404',
    component: NotFound
});


// ** redirect to 404 for invalid urls **
routes.push({
    path: '*',
    redirect: {name: '404'}
});


export default new VueRouter({
    routes,
    mode: 'history'
});


