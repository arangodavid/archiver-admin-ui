import EM from './event-emitter.js';
import AlertsEmitter from '../components/alert-emitter.vue';

export default function(url, init) {
    return fetch(url, init)
        .then(response => {
            if (response.ok) {
                return response.json();

            } else {
                console.log(response);
                throw new Error(
                    'status: ' +response.status
                    +(response.statusText && ', message:' +response.statusText)
                );
            }
        })
        .then(json => {
            if (json.isSuccessful) {
                return json.returnedObject;

            } else {
                console.log(json);
                throw new Error(
                    'code: ' +json.code
                    +(json.messages.length > 0 && ', messages:' +json.messages.join(', '))
                );
            }
        })
        .catch(error => {
            console.log(error);

            let message = `
                <h2 class="slds-text-heading_small">ERROR</h2>
                <p>${url}</p>
                <p>${error.message}</p>
            `;
            EM.$emit(AlertsEmitter.PUSH, {
                type: 'error',
                message
            });

            throw error;
        })
}
