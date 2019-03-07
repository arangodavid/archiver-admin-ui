<template>
    <div>
        <h1 class="slds-text-heading_large slds-m-bottom_x-large">Bulk Jobs Manager</h1>
        <button @click="createJob" class="slds-button slds-button_brand">
            <icon icon="plus" class="slds-button__icon slds-button__icon_left" />
            Create New Config
        </button>

        <div class="primary-section" v-show="jobs.length > 0">
            <div class="slds-p-horizontal--large slds-p-vertical_medium">
                <h2 class="slds-text-heading_small">Existing Configs</h2>
            </div>
            <table class="slds-table slds-table_cell-buffer slds-table_bordered">
                <thead>
                    <tr class="slds-line-height_reset">
                        <th>Object</th>
                        <th>SQL Condition</th>
                        <th>Action</th>
                        <th>Job Log ID</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="slds-hint-parent" v-for="job in jobs" :key="job.id">
                        <td>
                            {{job.objectName}}
                        </td>
                        <td class="slds-cell-wrap">
                            {{job.sqlCondition}}
                        </td>
                        <td>
                            {{job.jobAction}}
                        </td>
                        <td>
                            {{job.LogId}}
                        </td>
                        <td>
                            <button @click="editJob(job.id)" class="slds-button slds-button_icon slds-button_icon-border" title="Edit">
                                <icon icon="pencil-alt" class="slds-button__icon" />
                            </button>
                            <button @click="deleteJob(job.id)" class="slds-button slds-button_icon slds-button_icon-border" title="Delete">
                                <icon icon="trash-alt" class="slds-button__icon" />
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br/>
        </div>

        <modal v-show="showModal" @close="showModal = false">
            <template v-slot:header>Create </template>

            <div class="slds-p-around_medium">
                <p>Sit nulla est ex deserunt exercitation anim occaecat. Nostrud ullamco deserunt aute id consequat veniam incididunt duis in sint irure nisi. Mollit officia cillum Lorem ullamco minim nostrud elit officia tempor esse quis. Cillum sunt ad dolore
                    quis aute consequat ipsum magna exercitation reprehenderit magna. Tempor cupidatat consequat elit dolor adipisicing.</p>
                <p>Dolor eiusmod sunt ex incididunt cillum quis nostrud velit duis sit officia. Lorem aliqua enim laboris do dolor eiusmod officia. Mollit incididunt nisi consectetur esse laborum eiusmod pariatur proident. Eiusmod et adipisicing culpa deserunt nostrud
                    ad veniam nulla aute est. Labore esse esse cupidatat amet velit id elit consequat minim ullamco mollit enim excepteur ea.</p>

                <div class="slds-m-top_large">
                    <button class="slds-button slds-button_neutral">Cancel</button>
                    <button class="slds-button slds-button_brand">Save</button>
                </div>
            </div>

        </modal>
    </div>
</template>

<script>
    import PageLoader from '../../components/page-loader.vue';
    import EM from '../../core/event-emitter.js';
    import API from '../../core/api.js';
    import Modal from '../../components/modal.vue';

    import Icons from '../../core/icons.js';
    import {faPlus, faPencilAlt, faTrashAlt} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faPlus, faPencilAlt, faTrashAlt);


    export default {
        //
        // LOCAL COMPONENTS
        //
        components: {
            Modal
        },

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                jobs: [],
                showModal: false
            }
        },

        //
        // METHODS
        //
        methods: {
            loadList() {
                EM.$emit(PageLoader.SHOW);
                API.getBulkJobList()
                    .then(data => {
                        EM.$emit(PageLoader.HIDE);
                        console.log(data);
                        this.jobs = data;
                    })
            },
            createJob() {

            },
            editJob: function(id) {
/*                EM.$emit(PageLoader.SHOW);
                API.bulkJobs.getList()
                    .then(data => {
                        EM.$emit(PageLoader.HIDE);
                        console.log(data);
                        this.jobs = data;
                    })*/
            },
            deleteJob: function(id) {
/*                let index = this.pool.findIndex((alert) => {
                    return alert.id == id;
                });
                this.pool.splice(index, 1);*/
            }
        },

        //
        // EVENTS
        //
        mounted() {
            this.loadList();
        }
    }
</script>

<style scoped>

</style>
